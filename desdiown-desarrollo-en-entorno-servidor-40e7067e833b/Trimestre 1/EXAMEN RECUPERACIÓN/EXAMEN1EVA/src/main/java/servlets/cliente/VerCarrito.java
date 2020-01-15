package servlets.cliente;

import exceptions.ClienteSinFondosException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import services.ProductosServicios;
import utils.Constants;
import utils.Utils;

@WebServlet(name = "VerCarrito", urlPatterns =
{
    "/cliente/carrito"
})
public class VerCarrito extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Utils utils = new Utils();
        List<Producto> carrito = (List<Producto>) request.getSession().getAttribute(Constants.SESSION_CARRITO);

        /* OP */
        String op = request.getParameter("op");
        if (null == op)
        {
            op = "";
        }
        ProductosServicios ps = new ProductosServicios();
        switch (op)
        {
            case "checkout":
                if (carrito != null && carrito.size() > 0)
                {
                    String clienteNombre = request.getSession().getAttribute(Constants.SESSION_USUARIO).toString();
                    if (null == clienteNombre)
                    {
                        clienteNombre = "";
                    }
                    boolean compraOK = false;
                    try
                    {
                        compraOK = ps.finalizarCompra(clienteNombre, carrito);
                    }
                    catch (ClienteSinFondosException ex)
                    {
                        request.setAttribute("cuentaSinFondosMsg", true);
                    }
                    
                    if (compraOK)
                    {
                        request.getSession().setAttribute(Constants.SESSION_CARRITO, null);
                        carrito = null;
                    }
                    request.setAttribute("compraOK", compraOK);
                } else
                {
                    request.setAttribute("compraOK", false);
                }
                break;
        }
        request.setAttribute("precioTotal", utils.calcularCosteCarrito(carrito));
        request.setAttribute("productos", carrito);
        request.getRequestDispatcher("carrito.jsp").forward(request, response);
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
