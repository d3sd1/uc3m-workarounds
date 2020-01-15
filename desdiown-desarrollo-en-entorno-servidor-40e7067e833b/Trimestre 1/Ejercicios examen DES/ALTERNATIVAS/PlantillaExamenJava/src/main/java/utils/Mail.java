package utils;

import configuration.Config;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mail
{
    /*
    * Esta función es la que envía un correo ya formateado al usuario
    */
    public boolean myMailSender(String mail)
    {
        /* Los textos deberían ir en las constantes de Language */
        return send(mail, "Bienvenido a la clase", "<a href='" + Config.getInstance().getSiteUrl() + "/algo'>Enlace de activación</a><br>Aquí se puede meter otra cosa");
    }
            
            
    /*
    * Funciones internas de la clase Mail
    */
    private boolean send(String to, String subject, String msg)
    {
        boolean success = false;
        try
        {
            Email email = new SimpleEmail();

            email.setHostName(Config.getInstance().getSmtpServer());
            email.setSmtpPort(Config.getInstance().getSmtpPort());
            email.setAuthentication(Config.getInstance().getMailFrom(), Config.getInstance().getMailPass());
            email.setStartTLSEnabled(true);
            email.setFrom(Config.getInstance().getMailFromName() + "<" + Config.getInstance().getMailFrom() + ">");
            email.setSubject(subject);
            email.setContent(msg, "text/html; charset=utf-8");
            email.addTo(to);
            email.send();
            
            success = true;
        }
        catch (EmailException ex)
        {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
