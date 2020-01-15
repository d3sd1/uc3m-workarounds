package wsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import modelo.User;
import modelo.WsData;

public class WsMessages
{

    public void sendData(Session sess, String msg, User user)
    {
        if (sess != null)
        {
            for (Session s : sess.getOpenSessions())
            {
                Gson gson = new GsonBuilder().create();

                try
                {
                    WsData data = new WsData();
                    data.setType("mensaje");
                    data.setMsg(msg);
                    data.setUser(user);
                    s.getBasicRemote().sendObject(gson.toJson(data));
                }
                catch (IOException | EncodeException ex)
                {

                }
            }
        }
    }
}
