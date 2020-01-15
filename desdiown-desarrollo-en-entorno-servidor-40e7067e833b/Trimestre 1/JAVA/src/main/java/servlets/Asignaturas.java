package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceAsignaturas;
import utils.Constants;

@WebServlet(name = "Asignaturas", urlPatterns = {"/asignaturas"})
public class Asignaturas extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServiceAsignaturas service = new ServiceAsignaturas();
        String action = request.getParameter(Constants.PARAMETER_NAME_ACTION);
        if(action == null)
        {
            action = "";
        }
        switch(action)
        {
            /* REMOVE SUBJECT */
            case Constants.PARAMETER_VALUE_ACTION_DELETE:
               response.getWriter().print(service.removeAsignatura(request.getParameterMap()));
            break;
            /* REMOVE SUBJECT WITH HIS GRADES */
            case Constants.PARAMETER_VALUE_ACTION_FORCEDELETE:
                response.getWriter().print(service.removeAsignaturaWithGrades(request.getParameterMap()));
            break;
            /* UPDATE SUBJECT */
            case Constants.PARAMETER_VALUE_ACTION_UPDATE:
                response.getWriter().print(service.updateAsignatura(request.getParameterMap()));
            break;
            /* ADD SUBJECT */
            case Constants.PARAMETER_VALUE_ACTION_ADD:
                response.getWriter().print(service.addAsignatura(request.getParameterMap()));
            break;
            /* SHOW SUBJECTS */
            default: /* Display CRUD by default. */
                request.setAttribute("asignaturas", service.listAsignaturas());
                request.getRequestDispatcher("crud_asignaturas.jsp").forward(request, response);
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
