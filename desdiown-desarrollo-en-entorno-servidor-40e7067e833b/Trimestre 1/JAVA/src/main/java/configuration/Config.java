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
    private long loginTimeExpireSeconds;
    private int descuento;
    private String driverDB;
    private String urlDB;
    private String userDB;
    private String passDB;

    public String getSiteUrl()
    {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl)
    {
        this.siteUrl = siteUrl;
    }

    public long getLoginTimeExpireSeconds()
    {
        return loginTimeExpireSeconds;
    }

    public void setLoginTimeExpireSeconds(long loginTimeExpireSeconds)
    {
        this.loginTimeExpireSeconds = loginTimeExpireSeconds;
    }

    public int getDescuento()
    {
        return descuento;
    }

    public void setDescuento(int descuento)
    {
        this.descuento = descuento;
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


}
