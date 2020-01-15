package wsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UsersDao;
import dao.WebsocketsDao;
import java.io.IOException;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import model.Channel;
import model.ChannelPermissions;
import model.Data;
import model.DateFilter;
import model.Message;
import model.User;
import utils.Constants;

public class ChatServices
{
    private Session session;
    /*
    Pasar sesión por constructor ya que todos los métodos lo utilizan...
    Además que el objeto se destruye cuando se acaba de jugar con él.
    Por lo que no hay que preocuparse ya que la sesión es siempre la misma.
    */
    public ChatServices(Session session)
    {
        this.session = session;
    }
    public void setUserConnected(boolean connected, User user, Session session)
    {
        UsersDao dao = new UsersDao();
        user.setOnline(connected);
        /* Marcar en la DB el estado del usuario */
        dao.setUserStatus(user);
        
        /* Mandar circular a todos los conectados marcando el usuario actual como conectado/desconectado */
        Data data = new Data();
        data.setType("user");
        user.setOnline(connected);
        data.setData(user);
        sendDataToAll(data);
    }
    public void askPermissionForChannelToOwner(ChannelPermissions perm, Session session)
    {
        boolean adminOnline = false;
        for (Session s : session.getOpenSessions())
        {
            int actualUserId = (int) s.getUserProperties().get("id");
            if (actualUserId == perm.getAdminUser().getId())
            {
                Data data = new Data();
                data.setType("permissions_request");
                perm.setAdminOnline(true);
                data.setData(perm);
                sendDataToUser(data, s);
                adminOnline = true;
                break;
            }
        }
        if (!adminOnline)
        {
            Data data = new Data();
            data.setType("permissions_request");
            perm.setAdminOnline(false);
            data.setData(perm);
            sendDataToUser(data, session);
        }
    }

    public void responsePermissionForChannelToAsker(ChannelPermissions perm, Session session)
    {
        for (Session s : session.getOpenSessions())
        {
            int actualUserId = (int) s.getUserProperties().get("id");
            if (actualUserId == perm.getAskingUser().getId())
            {
                Data data = new Data();
                data.setType("permissions_response");

                data.setData(perm);
                sendDataToUser(data, s);
            }
        }
    }

    public void getAllUsers()
    {
        UsersDao dao = new UsersDao();
        List<User> users = dao.loadAllUsers();
        for (User user : users)
        {
            Data data = new Data();
            data.setType("user");
            data.setData(user);
            sendDataToUser(data, this.session);
        }
    }

    public void getAllChannels(User user)
    {
        WebsocketsDao dao = new WebsocketsDao();
        List<Channel> channels = dao.loadAllChannels(user);
        for (Channel channel : channels)
        {
            Data data = new Data();
            data.setType("channel");
            data.setData(channel);
            sendDataToUser(data, this.session);
        }
    }

    public void getMessagesBetweenDates(DateFilter df, Session sender)
    {
        WebsocketsDao dao = new WebsocketsDao();
        List<Message> messages = dao.getMessagesBetweenDates(df);
        for (Message message : messages)
        {
            sendMessageToActualUser(message, sender);
        }
    }

    public void sendMessageToActualUser(Message msg, Session sender)
    {
        Data data = new Data();
        data.setType("message");
        data.setData(msg);
        sendDataToUser(data, sender);
    }

    public void sendMessageToUser(Message msg, Session sender, String recipeEmail)
    {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd  HH:mm:ss").create();
        if (msg.isSave())
        {
            WebsocketsDao dao = new WebsocketsDao();
            int msgId = dao.saveMessage(msg);
            msg.setId(msgId);
        }
        for (Session s : sender.getOpenSessions())
        {
            String userEmail = (String) sender.getUserProperties().get("email");
            if (userEmail.equals(recipeEmail))
            {
                Data data = new Data();
                data.setType("message");
                data.setData(msg);
                sendDataToUser(data, sender);
            }
        }
    }

    public void sendMessageToChannel(Message msg)
    {
        if (msg.isSave())
        {
            WebsocketsDao dao = new WebsocketsDao();
            int msgId = dao.saveMessage(msg);
            msg.setId(msgId);
        }
        int mainUserChannel = Integer.parseInt(this.session.getUserProperties().get("channel").toString());
        for (Session s : this.session.getOpenSessions())
        {
            int currentUserChannel = Integer.parseInt(s.getUserProperties().get("channel").toString());
            if (currentUserChannel == mainUserChannel)
            {
                Data data = new Data();
                data.setType("message");
                data.setData(msg);
                sendDataToUser(data, s);
            }
        }
    }

    public void sendDataToUser(Data data, Session sender)
    {
        Gson gson = new GsonBuilder().setDateFormat(Constants.DATE_FORMAT).create();

        try
        {
            sender.getBasicRemote().sendObject(gson.toJson(data));
        }
        catch (IOException | EncodeException ex)
        {
            
        }
    }

    public void sendDataToAll(Data data)
    {
        for (Session s : this.session.getOpenSessions())
        {
            sendDataToUser(data, s);
        }
    }
    
    public void closeSession(User user)
    {
        /* Mandar objeto de usuario al websocket para actualizar el estado de la lista en tiempo real */
        Data data = new Data();
        data.setType("user");
        user.setOnline(false);
        data.setData(user);
        sendDataToAll(data);
        /* Desconectar de la base de datos */
        setUserConnected(false, user, session);
        closeSession();
    }
    public void closeSession()
    {
        try
        {
            /* Cerrar la sesión del WS */
            session.close();
        }
        catch (IOException | NullPointerException ex)
        {
            
        }
    }
    public Channel addChannel(Channel channel)
    {
        WebsocketsDao dao = new WebsocketsDao();
        if(channel.getName() != null && channel.getPassword() != null && !channel.getName().equals("") && !channel.getPassword().equals(""))
        {
            channel = dao.addChannel(channel);
        }
        return channel;
    }
    public User findChannelOwner(Channel channel)
    {
        WebsocketsDao dao = new WebsocketsDao();
        return dao.findChannelOwner(channel);
    }
    public void addPermisionsChannelUser(ChannelPermissions subChannelPermissions)
    {
        WebsocketsDao dao = new WebsocketsDao();
        int userId = subChannelPermissions.getAskingUser().getId();
        int channelId = subChannelPermissions.getChannel().getId();
        dao.addPermissionsToUserOnChannel(userId,channelId);
    }
}
