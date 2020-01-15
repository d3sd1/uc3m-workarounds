package yml;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class ConfigDatabase {
    
    private static ConfigDatabase database;

    private ConfigDatabase()
    {

    }

    public static ConfigDatabase getInstance()
    {
        return database;
    }

    public static ConfigDatabase getInstance(InputStream file, ServletContext sc)
    {
        if (database == null)
        {
            Yaml yaml = new Yaml();
            database = (ConfigDatabase) yaml.loadAs(file, ConfigDatabase.class);
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
