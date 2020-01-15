package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DeleteForceException;
import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.User;

@WebServlet(name = "Usuarios", urlPatterns =
{
    "/usuarios/*"
})
public class Usuarios extends HttpServlet
{
    /* Recuperar listado de usuarios */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        UserDAO dao = new UserDAO();
        response.getWriter().print(map.writeValueAsString(dao.getAllUser()));
    }
    
    /* Actualizar usuario */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            UserDAO dao = new UserDAO();
            User user = (User) request.getAttribute("user");
            /* Si no se ha enviado bien el body cogerlo por parametros */
            if(null == user.getName())
            {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                user.setName(name);
                user.setPassword(password);
            }
            dao.updateUser(user);
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            UserDAO dao = new UserDAO();
            User user = (User) request.getAttribute("user");
            /* Si no se ha enviado bien el body cogerlo por parametros */
            if(null == user.getName())
            {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                user.setName(name);
                user.setPassword(password);
            }
            dao.addUser(user);
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            UserDAO dao = new UserDAO();
            String pathInfo = request.getPathInfo();
            String[] pathParts = pathInfo.split("/");
            String nombreUsuario = pathParts[1];
            boolean forzarDelete = Boolean.parseBoolean(pathParts[2]);
            User user = dao.getUser(nombreUsuario);
            if(forzarDelete)
            {
                dao.delUserForce(user);
            }
            else
            {
                dao.delUser(user);
            }
            response.setStatus(200);
        }
        catch (DeleteForceException e)
        {
            response.setStatus(406);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

}
