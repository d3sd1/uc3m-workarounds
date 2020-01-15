package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceAlumnos;
import utils.Constants;

@WebServlet(name = "Alumnos", urlPatterns = {"/alumnos"})
public class Alumnos extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServiceAlumnos service = new ServiceAlumnos();
        String action = request.getParameter(Constants.PARAMETER_NAME_ACTION);
        if(action == null)
        {
            action = "";
        }
        switch(action)
        {
            /* REMOVE USER */
            case Constants.PARAMETER_VALUE_ACTION_DELETE:
                response.getWriter().print(service.removeAlumno(request.getParameterMap()));
            break;
            /* REMOVE USER WITH HIS GRADES */
            case Constants.PARAMETER_VALUE_ACTION_FORCEDELETE:
                response.getWriter().print(service.removeAlumnoWithGrades(request.getParameterMap()));
            break;
            /* UPDATE USER */
            case Constants.PARAMETER_VALUE_ACTION_UPDATE:
                response.getWriter().print(service.updateAlumno(request.getParameterMap()));
            break;
            /* ADD USER */
            case Constants.PARAMETER_VALUE_ACTION_ADD:
                request.getParameterMap();
                response.getWriter().print(service.addAlumno(request.getParameterMap()));
            break;
            /* SHOW USERS */
            default: /* Display CRUD by default. */
                request.setAttribute("alumnos", service.listAlumnos());
                request.getRequestDispatcher("crud_alumnos.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
