package services;

import configuration.Config;
import dao.LoginDAO;
import java.time.LocalDateTime;

public class LoginService
{

    public boolean loginUser(String username)
    {
        LoginDAO dao = new LoginDAO();
        boolean loggedIn = false;
        System.out.println("findUserByName: " + dao.findUserByName(username) + "& isUserActive" +  dao.isUserActive(username));
        if (dao.findUserByName(username) && dao.isUserActive(username))
        {
            try
            {
                LocalDateTime activationDate = dao.getUserActivationDate(username);
                LocalDateTime actualDate = LocalDateTime.now().minusSeconds(Config.getInstance().getLoginTimeExpireSeconds());
                /* Verificar si se ha pasado el periodo de expiración */
                System.out.println("isafetrr:" + activationDate.isAfter(actualDate));
                if (activationDate.isAfter(actualDate))
                {
                    loggedIn = false;
                    dao.setUserInactive(username);
                }
                else
                {
                    loggedIn = true;
                }
            }
            catch(NullPointerException e)
            {
                loggedIn = false;
            }
        }
        return loggedIn;
    }

    public boolean loginPhpUser(String username, String password)
    {
        LoginDAO dao = new LoginDAO();
        boolean loggedIn = false;
        if (dao.findPhpUserByLogin(username, password))
        {
            loggedIn = true;
        }
        return loggedIn;
    }

    public boolean findPhpUserByName(String username)
    {
        LoginDAO dao = new LoginDAO();
        return dao.findPhpUserByName(username);
    }
}
