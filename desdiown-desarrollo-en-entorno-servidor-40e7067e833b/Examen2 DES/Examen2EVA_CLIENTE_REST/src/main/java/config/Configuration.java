package config;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class Configuration {

    private static Configuration config;

    private Configuration() {

    }

    public static Configuration getInstance() {

        return config;
    }

    public static Configuration getInstance(InputStream file,ServletContext sc) {
        if (config == null) {
            Yaml yaml = new Yaml();
            config = (Configuration) yaml.loadAs(file, Configuration.class);
        }
        return config;
    }
    private String API_KEY;
    private String API_URL;
    private String CONTEXT_URL;

    public String getAPI_KEY()
    {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY)
    {
        this.API_KEY = API_KEY;
    }

    public String getAPI_URL()
    {
        return API_URL;
    }

    public void setAPI_URL(String API_URL)
    {
        this.API_URL = API_URL;
    }

    public String getCONTEXT_URL()
    {
        return CONTEXT_URL;
    }

    public void setCONTEXT_URL(String CONTEXT_URL)
    {
        this.CONTEXT_URL = CONTEXT_URL;
    }
    
}
