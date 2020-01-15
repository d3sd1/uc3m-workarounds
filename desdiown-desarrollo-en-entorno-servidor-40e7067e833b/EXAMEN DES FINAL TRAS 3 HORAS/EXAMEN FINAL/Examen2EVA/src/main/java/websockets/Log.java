package websockets;

import java.io.IOException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

@ServerEndpoint(value = "/logs")
public class Log extends ServerEndpointConfig.Configurator
{

    @OnOpen
    public void onOpen(Session session, @PathParam("type") String type, @PathParam("email") String email, @PathParam("passOrToken") String passOrToken, EndpointConfig config)
    {
        
    }

    @OnClose
    public void OnClose(Session session, @PathParam("user") String email)
    {
        try
        {
            session.close();
        }
        catch (IOException ex)
        {
            //Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnMessage
    public void echoText(String json, Session session)
    {
        /* Simplemente reenviar el JSON, ya que ahí están todos los datos */
        for (Session s : session.getOpenSessions())
        {
            try
            {
                s.getBasicRemote().sendText(json);
            }
            catch (IOException ex)
            {

            }
        }
    }
}
