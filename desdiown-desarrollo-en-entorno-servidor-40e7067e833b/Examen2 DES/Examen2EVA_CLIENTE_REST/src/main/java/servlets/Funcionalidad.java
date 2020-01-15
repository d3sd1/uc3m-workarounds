package servlets;

import Exceptions.ApiErrorException;
import Exceptions.ApiIntegrityError;
import Exceptions.ApiInvalidQueryException;
import Exceptions.ApiKeyInvalidException;
import Exceptions.ApiRateLimitException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.FuncionalidadServicios;

@WebServlet(name = "Funcionalidad", urlPatterns =
{
    "/funcionalidad"
})
public class Funcionalidad extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        FuncionalidadServicios service = new FuncionalidadServicios();
        try
        {
            String op = request.getParameter("op");
            String name = "", password = "";
            if (op != null)
            {
                name = request.getParameter("name");
                password = request.getParameter("password");
            }
            else
            {
                op = "";
            }
            switch (op)
            {
                case "adduser":
                    service.addUser(name, password);
                    break;
                case "upduser":
                    service.updUser(name, password);
                    break;
                case "deluser":
                    service.delUser(name);
                    break;
                case "fdeluser":
                    service.fDelUser(name);
                    break;
            }
            request.setAttribute("usuarios", service.listUsuarios());
            request.getRequestDispatcher("funcionalidad.jsp").forward(request, response);
        }
        catch (ApiIntegrityError e)
        {
            e.printStackTrace();
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
