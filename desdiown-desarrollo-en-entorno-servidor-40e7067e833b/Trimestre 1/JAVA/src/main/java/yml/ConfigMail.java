package yml;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class ConfigMail {

    
    private static ConfigMail mail;

    private ConfigMail()
    {

    }

    public static ConfigMail getInstance()
    {
        return mail;
    }

    public static ConfigMail getInstance(InputStream file, ServletContext sc)
    {
        if (mail == null)
        {
            Yaml yaml = new Yaml();
            mail = (ConfigMail) yaml.loadAs(file, ConfigMail.class);
        }
        return mail;
    }
    
    private String mailFrom;
    private String smtpServer;
    private int smtpPort;
    private String mailPass;
    private int limitActivationMins;

    public String getMailFrom()
    {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom)
    {
        this.mailFrom = mailFrom;
    }

    public String getSmtpServer()
    {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer)
    {
        this.smtpServer = smtpServer;
    }

    public int getSmtpPort()
    {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort)
    {
        this.smtpPort = smtpPort;
    }

    public String getMailPass()
    {
        return mailPass;
    }

    public void setMailPass(String mailPass)
    {
        this.mailPass = mailPass;
    }

    public int getLimitActivationMins()
    {
        return limitActivationMins;
    }

    public void setLimitActivationMins(int limitActivationMins)
    {
        this.limitActivationMins = limitActivationMins;
    }

}
