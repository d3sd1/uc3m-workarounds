package services;

import dao.TestDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import utils.Security;

public class TestService
{

    /*
        Aquí sólo se preparan los datos con los parámetros que ya están dados.
        Los mastica y se los pasa al dao como un objeto.
     */
    public boolean login(String mail, String password)
    {
        boolean isValidLogin = false;
        User user = new User();
        user.setEmail(mail);
        user.setPassword(password);
        try
        {
            TestDAO dao = new TestDAO();
            User userDB = dao.getUserByMail(mail);
            boolean passCorrecta = new Security().checkPass(user.getPassword(), userDB.getPassword());
            if (passCorrecta == true)
            {
                isValidLogin = true;
            }

        }
        catch (Exception ex)
        {
            Logger.getLogger(TestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValidLogin;
    }
}
