package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import yml.ConfigMail;

public class SendMail
{

    public void sendActivationCode(String email, String activationCode)
    {
        this.send(email, "Bienvenido a la clase", "<a href='http://localhost:8080/useractions?action=send&type=verify&code=" + activationCode + "&redirect=true'>Enlace de activación</a><br>Código de activación: " + activationCode);
    }
    public void send(String to, String subject, String msg)
    {
        try
        {
            Email email = new SimpleEmail();

            email.setHostName(ConfigMail.getInstance().getSmtpServer());
            email.setSmtpPort(ConfigMail.getInstance().getSmtpPort());
            email.setAuthentication(ConfigMail.getInstance().getMailFrom(), ConfigMail.getInstance().getMailPass());
            email.setStartTLSEnabled(true);
            email.setFrom("Clase DAW<" + ConfigMail.getInstance().getMailFrom() + ">");
            email.setSubject(subject);
            email.setContent(msg, "text/html; charset=utf-8");
            email.addTo(to);

            email.send();
        }
        catch (EmailException ex)
        {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
