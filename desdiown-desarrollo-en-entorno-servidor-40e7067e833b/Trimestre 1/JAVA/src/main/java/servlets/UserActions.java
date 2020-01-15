package servlets;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ServiceActions;
import utils.Constants;

@WebServlet(name = "useractions", urlPatterns =
{
    "/useractions"
})
public class UserActions extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServiceActions useractions = new ServiceActions();
        String action = request.getParameter(Constants.PARAMETER_NAME_ACTION);
        if (action == null)
        {
            action = "";
        }
        switch (action)
        {
            case Constants.PARAMETER_VALUE_ACTION_DO:
                String op = request.getParameter(Constants.PARAMETER_NAME_SENDOP);
                switch (op)
                {
                    case Constants.PARAMETER_VALUE_ACTION_VERIFY:
                        boolean redirect = false;
                        try
                        {
                            if(request.getParameterValues("redirect")[0] != null)
                            {
                                redirect = true;
                            }
                        }
                        catch (Exception e)
                        {

                        }
                        if(!redirect)
                        {
                            response.getWriter().print(useractions.doVerify(request.getParameterMap()));
                        }
                        else
                        {
                            useractions.doVerify(request.getParameterMap());
                            response.sendRedirect("/useractions?activated=true");
                        }
                        break;
                    case Constants.PARAMETER_VALUE_ACTION_REGISTER:
                        response.getWriter().print(useractions.doRegister(request.getParameterMap()));
                        break;
                    case Constants.PARAMETER_VALUE_ACTION_LOGIN:
                        AjaxMaker ajax = new AjaxMaker();
                        HttpSession session = request.getSession();
                        AjaxResponse doLogin = useractions.checkLogin(request.getParameterMap());
                        if(doLogin.isSuccess())
                        {
                            session.setAttribute(Constants.SESSION_NAME_LOGIN, 1);
                        }
                        response.getWriter().print(ajax.parseResponse(doLogin));
                        break;
                    default:
                        request.getRequestDispatcher("useractions/login.jsp").forward(request, response);
                }
                break;
            case Constants.PARAMETER_VALUE_ACTION_REGISTER:
                request.getRequestDispatcher("useractions/register.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("useractions/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
