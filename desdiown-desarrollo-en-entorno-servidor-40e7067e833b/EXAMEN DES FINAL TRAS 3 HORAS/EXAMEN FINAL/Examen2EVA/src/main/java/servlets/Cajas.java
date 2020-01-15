package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Caja;
import modelo.User;

@WebServlet(name = "Cajas", urlPatterns =
{
    "/cajas/*"
})
public class Cajas extends HttpServlet
{

    /* Listar cajas del usuario */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        UserDAO uDao = new UserDAO();
        try
        {
            User user = (User) request.getAttribute("user");
            response.getWriter().print(map.writeValueAsString(uDao.getAllCajasUser(user)));
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

    /* Añadir una caja nueva al usuario  */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserDAO uDao = new UserDAO();
        try
        {
            User user = (User) request.getAttribute("user");
            String nombreCaja = request.getParameter("cajanombre");
            Caja caja = new Caja();
            caja.setNombre(nombreCaja);
            uDao.addCajaAUser(user, caja);
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

}
