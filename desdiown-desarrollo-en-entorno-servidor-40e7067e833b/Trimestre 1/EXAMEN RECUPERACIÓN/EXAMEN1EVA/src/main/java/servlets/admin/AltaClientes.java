package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UsuariosServicios;

@WebServlet(name = "AltaClientes", urlPatterns =
{
    "/admin/alta_clientes"
})
public class AltaClientes extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String op = request.getParameter("op");
        if (null == op)
        {
            op = "";
        }

        switch (op)
        {
            case "add":
                UsuariosServicios us = new UsuariosServicios();
                String nombre = request.getParameter("nombre"),
                 contrasena = request.getParameter("contrasena"),
                 saldoStr = request.getParameter("saldo");
                double saldo = 0;
                if(null != saldoStr)
                {
                    saldo = Double.parseDouble(saldoStr);
                }
                if (us.addCliente(nombre, contrasena, saldo))
                {
                    request.setAttribute("agregado", true);
                } else
                {
                    request.setAttribute("agregado", false);
                }
                break;
        }
        request.getRequestDispatcher("alta_cliente.jsp").forward(request, response);
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
