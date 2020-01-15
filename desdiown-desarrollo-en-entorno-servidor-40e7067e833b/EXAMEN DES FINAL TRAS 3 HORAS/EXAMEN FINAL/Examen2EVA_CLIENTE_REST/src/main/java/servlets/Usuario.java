package servlets;

import Exceptions.ApiErrorException;
import Exceptions.ApiInvalidQueryException;
import Exceptions.ApiKeyInvalidException;
import Exceptions.ApiRateLimitException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.User;
import services.UsuarioServicios;

@WebServlet(name = "Usuario", urlPatterns =
{
    "/usuario"
})
public class Usuario extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String nombreCaja = request.getParameter("cajanombre");
        String nombreCosa = request.getParameter("cosanombre");
        String cantidadCosa = request.getParameter("cosacantidad");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UsuarioServicios service = new UsuarioServicios(user);
        try
        {
            String op = request.getParameter("op");
            if(op == null)
            {
                op = "";
            }
            switch (op)
            {
                case "addcaja":
                    service.addCaja(nombreCaja);
                    break;
                case "listarcosas":
                        request.setAttribute("cosas", service.listCosas(nombreCaja));
                    break;
                case "addcantidad":
                        service.addCantidad(nombreCaja,nombreCosa,cantidadCosa);
                    break;
                case "addcosa":
                        service.addCosa(nombreCaja,nombreCosa,cantidadCosa);
                    break;
                default:
            }
            request.setAttribute("cajas", service.listCajas());
            request.getRequestDispatcher("usuario.jsp").forward(request, response);
        }
        catch (ApiErrorException e)
        {
            request.setAttribute("cod_error", 500);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (ApiRateLimitException e)
        {
            request.setAttribute("cod_error", 406);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (ApiKeyInvalidException e)
        {
            request.setAttribute("cod_error", 401);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (ApiInvalidQueryException e)
        {
            request.setAttribute("cod_error", 400);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("cod_error", 500);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
