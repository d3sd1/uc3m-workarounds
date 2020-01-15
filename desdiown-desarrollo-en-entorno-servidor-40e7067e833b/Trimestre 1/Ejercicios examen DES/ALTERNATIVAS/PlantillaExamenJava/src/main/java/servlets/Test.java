package servlets;

import configuration.Config;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TestService;

@WebServlet(name = "Test", urlPatterns = { "/Test" })
public class Test extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
        AQUÍ SOLO COSAS DE HTTP. TODO LO RELACIONADO CON PARÁMETROS SE PARSEA AQUÍ, Y SE PASAN INDIVIDUALMENTE AL SERVICIO 
        
        * Iniciar servicio:
            NombreServicio ns = new NombreServicio();
        
        * Recoger parámetro por nombre: (Si no existe retorna null)
            request.getParameter("PARAMETRO");
        
        * Guardar sesión: (Si no existe retorna null)
            request.getSession().setAttribute("NOMBRE", "VALOR");
        
        * Eliminar todas las sesiones: 
            request.getSession().invalidate();
        
        * Redirección a otro servlet:
            response.sendRedirect("/SERVLET")
        * Enviar respuesta al servlet:
            request.getRequestDispatcher("NOMBRE_JSP.jsp").forward(request, response);
        
        * Pasar variable de servlet a JSP:
            request.setAttribute("variable", "valor");
        
        * Recoger variable de servlet en JSP:
            <c:out value="${variable}"></c:out>
        
        * Bucle en JSP:
            
        */
        TestService ns = new TestService();
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        if(ns.login(mail,password))
        {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
