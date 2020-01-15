package wsServices;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import dao.UsersDao;
import model.Login;
import model.User;
import utils.IdTokenVerifierAndParser;
import utils.PasswordHash;

public class LoginServices
{

    public Login doLogin(String type, String email, String passOrToken)
    {
        User loginUser;
        Login loginStatus = new Login();
        
        if (type.equals("google"))
        {
            /* Logear con google */
            loginUser = googleLogin(passOrToken);
        }
        else
        {
            /* Logear por DB */
            loginUser = dbLogin(email, passOrToken);
        }

        if (loginUser.getId() != 0)
        {
            /* Conexión satisfactoria */
            loginStatus.setStatus(true);
            loginStatus.setUser(loginUser);
        }
        else
        {
            /* Conexión inválida */
            loginStatus.setStatus(false);
            loginStatus.setUser(new User());

        }
        return loginStatus;
    }
    private User dbLogin(String email, String pass)
    {
        User user = new User();
        try
        {
            UsersDao dao = new dao.UsersDao();
            User loginUser = new User();
            loginUser.setEmail(email);
            loginUser.setPass(pass);
            user = dao.getUser(loginUser, true, true);
            boolean validPass = PasswordHash.getInstance().validatePassword(pass, user.getPass());
            if (!validPass)
            {
                user.setId(0);
            }
        }
        catch (Exception e)
        {
            user.setId(0);
        }
        return user;
    }

    private User googleLogin(String tokenId)
    {
        User user = new User();
        GoogleIdToken.Payload payLoad;
        try
        {
            payLoad = IdTokenVerifierAndParser.getPayload(tokenId);
            user.setEmail(payLoad.getEmail());
        }
        catch (Exception ex)
        {
            payLoad = null;
        }
        if (payLoad.getEmail() != null)
        {
            UsersDao dao = new dao.UsersDao();
            user.setEmail(payLoad.getEmail());
            user.setPass("google");
            user = dao.getUser(user, false, true);
        }
        return user;
    }

}
