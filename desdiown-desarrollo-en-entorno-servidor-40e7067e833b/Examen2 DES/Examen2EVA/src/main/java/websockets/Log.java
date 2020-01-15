package websockets;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import wsServices.CustomConfigurator;

@ServerEndpoint(value = "/logs",
        configurator = CustomConfigurator.class)
public class Log
{
    private Session wsSession;
    private HttpSession httpSession;

    public void setHttpSession(HttpSession httpSession) {
        if (this.httpSession != null) {
            throw new IllegalStateException("HttpSession has already been set!");
        }

        this.httpSession = httpSession;
    }

    @OnOpen
    public void open(Session session, EndpointConfig config) {
        this.wsSession = session;
        
        httpSession.setAttribute("wssession", wsSession);
    }

    @OnMessage
    public void echo(String msg) throws IOException {
        wsSession.getBasicRemote().sendText(msg);
    }
}
