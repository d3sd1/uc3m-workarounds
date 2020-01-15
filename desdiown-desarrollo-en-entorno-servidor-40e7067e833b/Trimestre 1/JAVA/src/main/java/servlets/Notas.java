package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ServiceAlumnos;
import services.ServiceAsignaturas;
import services.ServiceNotas;
import utils.Constants;

@WebServlet(name = "Notas", urlPatterns = {"/notas"})
public class Notas extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServiceAlumnos alumnos = new ServiceAlumnos();
        ServiceAsignaturas asignaturas = new ServiceAsignaturas();
        ServiceNotas notas = new ServiceNotas();
        String action = request.getParameter(Constants.PARAMETER_NAME_ACTION);
        if(action == null)
        {
            action = "";
        }
        switch(action)
        {
            /* UPDATE GRADE */
            case Constants.PARAMETER_VALUE_ACTION_UPDATE:
                response.getWriter().print(notas.updateNota(request.getParameterMap()));
            break;
            /* CHECK GRADE */
            case Constants.PARAMETER_VALUE_ACTION_CHECK:
                response.getWriter().print(notas.getNota(request.getParameterMap()));
            break;
            /* SHOW USERS AND SUBJECT MANAGER */
            default: /* Display CRUD by default. */
                request.setAttribute("alumnos", alumnos.listAlumnos());
                request.setAttribute("asignaturas", asignaturas.listAsignaturas());
                request.getRequestDispatcher("crud_grades.jsp").forward(request, response);
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
