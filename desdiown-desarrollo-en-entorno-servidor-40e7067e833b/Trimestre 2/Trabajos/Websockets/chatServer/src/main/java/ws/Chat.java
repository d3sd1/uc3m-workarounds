package ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UsersDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import model.Channel;
import model.ChannelPermissions;
import model.Data;
import model.DateFilter;
import model.Login;
import model.Message;
import model.User;
import utils.Constants;
import wsServices.ChatServices;
import wsServices.LoginServices;
import wsServices.MessageDecoder;
import wsServices.MessageEncoder;
import wsServices.ServletAwareConfig;

@ServerEndpoint(value = "/chat/{type}/{email}/{passOrToken}",
        configurator = ServletAwareConfig.class,
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class Chat extends ServerEndpointConfig.Configurator
{

    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, @PathParam("type") String type, @PathParam("email") String email, @PathParam("passOrToken") String passOrToken, EndpointConfig config)
    {
        httpSession = (HttpSession) config.getUserProperties().get("httpsession");
        session.getUserProperties().put("httpsession", httpSession);
        LoginServices uServ = new LoginServices();
        ChatServices serv = new ChatServices(session);

        /* Verificar si la conexión es válida */
        Login loginStatus = uServ.doLogin(type, email, passOrToken);
        /* Si la conexión es satisfactoria */
        if (loginStatus.getStatus())
        {
            /* Añadir a la sesión de websockets sus propiedades */
            session.getUserProperties().put("email", loginStatus.getUser().getEmail());
            session.getUserProperties().put("id", loginStatus.getUser().getId());
            session.getUserProperties().put("channel", 0);
            /* Indicar en la DB que está conectado y mandar objeto de usuario al websocket para actualizar el estado del usuario a los demás */
            serv.setUserConnected(true, loginStatus.getUser(), session);

            /* Meter a HTTPSession */
            List<User> usuariosOnline;
            try
            {
                usuariosOnline = (List<User>) httpSession.getAttribute("usuariosOnline");
                usuariosOnline.add(loginStatus.getUser());
            }
            catch (Exception e)
            {
                usuariosOnline = new ArrayList<>();
                usuariosOnline.add(loginStatus.getUser());
            }
            /* Si se pone fuera el usuariosOnline.add(loginStatus.getUser()); PETA POR NULLPOINTER */
            httpSession.setAttribute("usuariosOnline", usuariosOnline);
        }

        /* Mandar al usuario actual la resolución de la conexión */
        Data loginResponse = new Data();
        loginResponse.setType("login");
        loginResponse.setData(loginStatus);
        serv.sendDataToUser(loginResponse, session);

        /* Cerrar la conexión de WS si la conexión no fue satisfactoria */
        if (!loginStatus.getStatus())
        {
            serv.closeSession();
        }
        /* Limpiar serv de memoria para evitar que el objeto se reuse por la memoria de Java y cause duplicidad */
        System.runFinalization();
    }

    @OnClose
    public void OnClose(Session session, @PathParam("user") String email)
    {
        ChatServices serv = new ChatServices(session);
        UsersDao uDao = new UsersDao();
        User user = new User();
        Object userId = session.getUserProperties().get("id");
        if (userId != null)
        {
            user.setId(Integer.parseInt(userId.toString()));
            user = uDao.findUser(user);
            /* Sacar de HTTPSession */
            List<User> usuariosOnline;
            try
            {
                usuariosOnline = (List<User>) httpSession.getAttribute("usuariosOnline");
                /* Borrar usuario para que no salga conectado usando expresión lambda */
                final User rmUser = user;
                usuariosOnline.removeIf(u -> u.getEmail().equals(rmUser.getEmail()));
                httpSession.setAttribute("usuariosOnline", usuariosOnline);
            }
            catch (Exception e)
            {
                
            }
            serv.closeSession(user);
        }

        /* Limpiar serv de memoria para evitar que el objeto se reuse por la memoria de Java y cause duplicidad */
        System.runFinalization();
    }

    @OnMessage
    public void echoText(Data data, Session session)
    {
        /* Objetos a usar y data */
        UsersDao usersDao = new UsersDao();
        ChatServices serv = new ChatServices(session);
        Gson gson = new GsonBuilder().setDateFormat(Constants.DATE_FORMAT).create();

        /* Usuario actual */
        User user = new User();
        user.setId(Integer.parseInt(session.getUserProperties().get("id").toString()));
        user = usersDao.findUser(user);

        /* Canal actual */
        Channel channel = new Channel();
        channel.setId(Integer.parseInt(session.getUserProperties().get("channel").toString()));

        /* OP */
        switch (data.getType())
        {
            case "message":
                Message msg = gson.fromJson(data.getData(), Message.class);
                msg.setChannel_id(channel.getId());
                msg.setSender(user);
                serv.sendMessageToChannel(msg);
                break;
            case "filter_dates":
                DateFilter df = gson.fromJson(data.getData(), DateFilter.class);
                df.setChannel(channel);
                serv.getMessagesBetweenDates(df, session);
                break;
            case "all_users":
                serv.getAllUsers();
                break;
            case "all_channels":
                serv.getAllChannels(user);
                break;
            case "change_channel":
                Channel newChannel = gson.fromJson(data.getData(), Channel.class);
                session.getUserProperties().put("channel", newChannel.getId());
                break;
            case "subscribe_channel":
                Channel subChannel = gson.fromJson(data.getData(), Channel.class);

                ChannelPermissions perm = new ChannelPermissions();
                User owner = serv.findChannelOwner(subChannel);
                perm.setAdminUser(owner);
                perm.setAskingUser(user);
                perm.setChannel(subChannel);
                serv.askPermissionForChannelToOwner(perm, session);
                break;
            case "grant_permissions_channel":
                ChannelPermissions subChannelPermissions = gson.fromJson(data.getData(), ChannelPermissions.class);
                if (subChannelPermissions.getGranted())
                {
                    serv.addPermisionsChannelUser(subChannelPermissions);
                }
                serv.responsePermissionForChannelToAsker(subChannelPermissions, session);
                break;
            case "add_channel":
                Channel channel2 = gson.fromJson(data.getData(), Channel.class);
                channel2.setAdmin_id(user.getId());
                Channel channelAdded = serv.addChannel(channel2);
                if (channelAdded.getId() != 0)
                {
                    /* Mandar datos a todos los usuarios conectados diciendo que el canal existe */
                    Data channelData = new Data();
                    channelData.setType("channel");
                    channelData.setData(channel2);
                    serv.sendDataToAll(channelData);
                }
                break;
        }
        /* Limpiar serv de memoria para evitar que el objeto se reuse por la memoria de Java y cause duplicidad */
        System.runFinalization();
    }
}
