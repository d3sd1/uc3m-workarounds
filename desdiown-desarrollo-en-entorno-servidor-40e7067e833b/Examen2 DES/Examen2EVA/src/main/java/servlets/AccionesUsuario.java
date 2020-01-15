package servlets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CajaDAO;
import dao.UserDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import modelo.Caja;
import modelo.Cosa;
import modelo.User;
import wsServices.WsMessages;

@WebServlet(name = "AccionesUsuario", urlPatterns =
{
    "/acciones_usuario/*"
})
public class AccionesUsuario extends HttpServlet
{

    /* Listar cajas del usuario que llama */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        UserDAO uDao = new UserDAO();
        CajaDAO cDao = new CajaDAO();
        WsMessages ws = new WsMessages();
        Session wsSess = (Session) request.getSession().getAttribute("wssession");
        try
        {
            String pathInfo = request.getPathInfo();
            String nombre_caja = null;
            User user = (User) request.getAttribute("user");

            /* Revisar si se ha enviado path param sin que de nullpointers */
            if (null != pathInfo)
            {
                String[] pathParts = pathInfo.split("/");
                nombre_caja = pathParts[1];
            }

            /* Listar cajas del usuario que llama */
            if (null == nombre_caja)
            {
                response.getWriter().print(map.writeValueAsString(uDao.getAllCajasUser(user)));
                ws.sendData(wsSess, "Listado cajas del usuario.", user);
            }
            /* Listar contenido de la caja de un usuario (Si se ha enviado la ID por path param */
            else
            {
                response.getWriter().print(map.writeValueAsString(cDao.getCaja(nombre_caja)));
                ws.sendData(wsSess, "Listado contenido caja del usuario.", user);
            }
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

    /* OP:
    1. Añadir cosas a la caja de un usuario.
    2. Añadir cantidad de cosas a la caja de un usuario
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        CajaDAO cDao = new CajaDAO();
        try
        {
            String pathInfo = request.getPathInfo();
            String nombre_caja = null,
                    accion = null;
            User user = (User) request.getAttribute("user");

            /* Revisar si se ha enviado path param sin que de nullpointers */
            if (null != pathInfo)
            {
                String[] pathParts = pathInfo.split("/");
                nombre_caja = pathParts[1];
            }

            /* Listar cajas del usuario que llama */
            List<Cosa> cosas = map.readValue(request.getAttribute("json").toString(), new TypeReference<Caja>()
            {
            });
            if (accion.equals("cantidad"))
            {
                for (Cosa cosa : cosas)
                {
                    cDao.addCantidadCosaACaja(cosa, cDao.getCaja(nombre_caja));
					ws.sendData(wsSess, "Añadida cantidad a caja de usuario.", user);
                }
            }
            else
            {
                for (Cosa cosa : cosas)
                {
                    cDao.addCosaACaja(cosa, cDao.getCaja(nombre_caja));
					ws.sendData(wsSess, "Añadidas cosas a caja de usuario.", user);
                }
            }
            response.setStatus(200);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.setStatus(400);
        }
    }

    /* Añadir una caja nueva al usuario  */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        UserDAO uDao = new UserDAO();
        try
        {
            User user = (User) request.getAttribute("user");

            Caja caja = map.readValue(request.getAttribute("json").toString(), new TypeReference<Caja>()
            {
            });
            response.getWriter().print(map.writeValueAsString(uDao.addCajaAUser(user, caja)));
			ws.sendData(wsSess, "Añadida caja nueva al usuario.", user);
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

}
