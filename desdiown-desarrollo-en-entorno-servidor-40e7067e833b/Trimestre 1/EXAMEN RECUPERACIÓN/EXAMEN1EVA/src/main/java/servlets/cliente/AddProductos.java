package servlets.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import services.ProductosServicios;
import utils.Constants;

@WebServlet(name = "AddProductos", urlPatterns =
{
    "/cliente/addproductos"
})
public class AddProductos extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        /*
        Inicializar carrito si este no fue tratado aún
        para evitar nullpointers
        */
        Object carritoObj = request.getSession().getAttribute(Constants.SESSION_CARRITO);
        if(null == carritoObj)
        {
            List<Producto> carritoSession = new ArrayList();
            request.getSession().setAttribute(Constants.SESSION_CARRITO,carritoSession);
        }
        /* OP */
        String op = request.getParameter("op");
        if (null == op)
        {
            op = "";
        }

        ProductosServicios ps = new ProductosServicios();
        switch (op)
        {
            case "buscar":
                String categoria = request.getParameter("cat");
                request.setAttribute("buscado", true);
                request.setAttribute("productos", ps.buscarProductos(categoria));
                break;
            case "addcarrito":
                String nombre = request.getParameter("nombre_producto");
                String cantidadStr = request.getParameter("cantidad");
                int cantidad = 0;
                if(null != cantidadStr)
                {
                    cantidad = Integer.parseInt(cantidadStr);
                }
                if (ps.getStock(nombre) >= cantidad)
                {
                    List<Producto> carrito = (List<Producto>) request.getSession().getAttribute(Constants.SESSION_CARRITO);
                    Producto producto = ps.getProducto(nombre,cantidad);
                    carrito.add(producto);
                    request.getSession().setAttribute(Constants.SESSION_CARRITO, carrito);
                    request.setAttribute("agregadoCarrito", true);
                } else
                {
                    request.setAttribute("agregadoCarrito", false);
                }
                break;
        }
        request.getRequestDispatcher("add_producto.jsp").forward(request, response);
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
