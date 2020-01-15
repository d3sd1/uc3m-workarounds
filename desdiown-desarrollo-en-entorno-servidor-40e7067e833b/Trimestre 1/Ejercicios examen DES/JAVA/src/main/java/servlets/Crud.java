package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import services.CrudService;

@WebServlet(name = "Crud", urlPatterns = { "/crud" })
public class Crud extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
        no he podido organizar los paquetes por falta de tiempo.
        asi mismo pueden fallar las partes de javascript ya que no las priorice, por falta de tiempo.
        */
        CrudService cs = new CrudService();
        String action = request.getParameter("action");
        String page = "";
        if(action == null)
        {
            action = "";
        }
        Car cochecito = new Car();
        cochecito.setId(Integer.parseInt(request.getParameter("idcoche")));
        cochecito.setCoche(request.getParameter("coche"));
        cochecito.setComprado(Boolean.parseBoolean(request.getParameter("idcoche")));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaCompra = LocalDate.parse(request.getParameter("fecha_compra"), dtf);
        cochecito.setFecha_compra(Date.from(fechaCompra.atStartOfDay().toInstant(ZoneOffset.UTC)));
        cochecito.setKm(Integer.parseInt(request.getParameter("km")));
        switch(action)
        {
            /* insertar o actualizar dependiendo de si existe */
            case "insert":
                
                if(cs.insertCar(cochecito))
                {
                    request.setAttribute("message", "Coche editado correctamente");
                }
                else
                {
                    request.setAttribute("message", "Error al editar coche");
                }
            break;
            /* insertar o actualizar dependiendo de si existe */
            case "update":
                
                if(cs.updateCar(cochecito))
                {
                    request.setAttribute("message", "Coche editado correctamente");
                }
                else
                {
                    request.setAttribute("message", "Error al editar coche");
                }
            break;
            /* Eliminar */
            case "delete":
                if(cs.deleteCar(cochecito))
                {
                    request.setAttribute("message", "Coche editado correctamente");
                }
                else
                {
                    request.setAttribute("message", "Error al editar coche");
                }
            break;
            /* Mostrar crud */
            default:
                request.setAttribute("cars", cs.getAllCars());
                page = "crud.jsp";
        }
        request.getRequestDispatcher(page).forward(request, response);
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
