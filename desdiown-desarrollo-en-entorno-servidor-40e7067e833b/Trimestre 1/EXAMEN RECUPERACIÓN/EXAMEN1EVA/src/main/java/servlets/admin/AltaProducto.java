package servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProductosServicios;
import services.UsuariosServicios;

@WebServlet(name = "AltaProducto", urlPatterns =
{
    "/admin/alta_producto"
})
public class AltaProducto extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String op = request.getParameter("op");
        if (null == op)
        {
            op = "";
        }

        ProductosServicios us = new ProductosServicios();
        /* Preparar producto para todos los case */
        String nombre = request.getParameter("nombre"),
                precioStr = request.getParameter("precio"),
                unidadesStr = request.getParameter("unidades"),
                categoria = request.getParameter("categoria");
        double precio = 0;
        if (null != precioStr && !precioStr.equals(""))
        {
            precio = Double.parseDouble(precioStr);
        }
        int unidades = 0;
        if (null != unidadesStr && !unidadesStr.equals(""))
        {
            unidades = Integer.parseInt(unidadesStr);
        }
        
        /* OP */
        switch (op)
        {
            case "add":
                if (us.addProducto(nombre, precio, unidades, categoria))
                {
                    request.setAttribute("agregado", true);
                } else
                {
                    request.setAttribute("agregado", false);
                }
                break;
            case "update":
                if (us.updateProducto(nombre, precio, unidades, categoria))
                {
                    request.setAttribute("actualizado", true);
                } else
                {
                    request.setAttribute("actualizado", false);
                }
                break;
        }
        request.getRequestDispatcher("alta_producto.jsp").forward(request, response);
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
