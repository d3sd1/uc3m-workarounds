package config;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class Config {
    
    private static Config database;

    private Config()
    {

    }

    public static Config getInstance()
    {
        return database;
    }

    public static Config getInstance(InputStream file, ServletContext sc)
    {
        if (database == null)
        {
            Yaml yaml = new Yaml();
            database = (Config) yaml.loadAs(file, Config.class);
        }
        return database;
    }

    private String driverDB;
    private String urlDB;
    private String userDB;
    private String passDB;

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
