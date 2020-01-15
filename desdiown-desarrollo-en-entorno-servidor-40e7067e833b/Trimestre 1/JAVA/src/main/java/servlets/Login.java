package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.LoginService;

@WebServlet(name = "Login", urlPatterns =
{
    "/login"
})
public class Login extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LoginService ls = new LoginService();
        String action = request.getParameter("action");
        if(action == null)
        {
            action = "";
        }
        String destinyPage = "";
        switch (action)
        {
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (ls.loginUser(username))
                {
                    request.getSession().setAttribute("userName", username);
                    destinyPage = "login_success.jsp";
                }
                else
                {
                    if (ls.loginPhpUser(username, password))
                    {
                        request.getSession().setAttribute("userName", username);
                        destinyPage = "login_success.jsp";
                    }
                    else if(!ls.findPhpUserByName(username))
                    {
                        request.setAttribute("errorMessage", "El usuario introducido no existe.");
                        destinyPage = "login_error.jsp";
                    }
                    else
                    {
                        request.setAttribute("errorMessage", "Contraseña incorrecta.");
                        destinyPage = "login_error.jsp";
                    }
                }
                break;
            default:
                destinyPage = "login.jsp";
        }
        request.getRequestDispatcher(destinyPage).forward(request, response);
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
