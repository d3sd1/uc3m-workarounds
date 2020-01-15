package configuration;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class Config
{

    private static Config config;

    private Config()
    {

    }

    public static Config getInstance()
    {

        return config;
    }

    public static Config getInstance(InputStream file, ServletContext sc)
    {
        if (config == null)
        {
            Yaml yaml = new Yaml();
            config = (Config) yaml.loadAs(file, Config.class);
        }
        return config;
    }
    private String siteUrl;
    private String driverDB;
    private String urlDB;
    private String userDB;
    private String passDB;
    private String mailFrom;
    private String mailFromName;
    private String smtpServer;
    private int smtpPort;
    private String mailPass;

    public String getSiteUrl()
    {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl)
    {
        this.siteUrl = siteUrl;
    }

    public String getDriverDB()
    {
        return driverDB;
    }

    public void setDriverDB(String driverDB)
    {
        this.driverDB = driverDB;
    }

    public String getUrlDB()
    {
        return urlDB;
    }

    public void setUrlDB(String urlDB)
    {
        this.urlDB = urlDB;
    }

    public String getUserDB()
    {
        return userDB;
    }

    public void setUserDB(String userDB)
    {
        this.userDB = userDB;
    }

    public String getPassDB()
    {
        return passDB;
    }

    public void setPassDB(String passDB)
    {
        this.passDB = passDB;
    }

    public String getMailFrom()
    {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom)
    {
        this.mailFrom = mailFrom;
    }

    public String getMailFromName()
    {
        return mailFromName;
    }

    public void setMailFromName(String mailFromName)
    {
        this.mailFromName = mailFromName;
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

}
