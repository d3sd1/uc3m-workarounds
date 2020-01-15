package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CajaDAO;
import dao.PermisosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Caja;
import modelo.Cosa;
import modelo.User;

@WebServlet(name = "Cosas", urlPatterns =
{
    "/cosas/*"
})
public class Cosas extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ObjectMapper map = new ObjectMapper();
        PermisosDAO pDao = new PermisosDAO();
        try
        {
            User user = (User) request.getAttribute("user");
            CajaDAO cDao = new CajaDAO();

            String nombreCaja = request.getParameter("cajanombre");
            Caja caja = cDao.getCaja(nombreCaja);
            if (pDao.checkPermisoCajaUser(user, caja))
            {
                response.getWriter().print(map.writeValueAsString(caja));
            }
            else
            {
                response.setStatus(401);
            }
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        CajaDAO cDao = new CajaDAO();
        PermisosDAO pDao = new PermisosDAO();
        try
        {
            User user = (User) request.getAttribute("user");

            String nombreCaja = request.getParameter("cajanombre");
            Caja caja = cDao.getCaja(nombreCaja);

            String nombreCosa = request.getParameter("cosanombre");
            String cantidadCosa = request.getParameter("cosacantidad");
            int cantidad = 0;
            if (null != cantidadCosa)
            {
                cantidad = Integer.parseInt(cantidadCosa);
            }
            Cosa cosa = new Cosa();
            cosa.setCantidad(cantidad);
            cosa.setNombre(nombreCosa);

            if (pDao.checkPermisoCajaUser(user, caja))
            {
                cDao.addCantidadCosaACaja(cosa, caja);
                response.setStatus(200);
            }
            else
            {
                response.setStatus(401);
            }
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CajaDAO cDao = new CajaDAO();
        PermisosDAO pDao = new PermisosDAO();
        try
        {
            User user = (User) request.getAttribute("user");

            String nombreCaja = request.getParameter("cajanombre");
            Caja caja = cDao.getCaja(nombreCaja);

            String nombreCosa = request.getParameter("cosanombre");
            String cantidadCosa = request.getParameter("cosacantidad");
            int cantidad = 0;
            if (null != cantidadCosa)
            {
                cantidad = Integer.parseInt(cantidadCosa);
            }
            Cosa cosa = new Cosa();
            cosa.setCantidad(cantidad);
            cosa.setNombre(nombreCosa);
            
            if (pDao.checkPermisoCajaUser(user, caja))
            {
                cDao.addCosaACaja(cosa, caja);
                response.setStatus(200);
            }
            else
            {
                response.setStatus(401);
            }
            
            response.setStatus(200);
        }
        catch (Exception e)
        {
            response.setStatus(400);
        }
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
