package yml;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class ConfigGeneral {
    
    private static ConfigGeneral general;

    private ConfigGeneral()
    {

    }

    public static ConfigGeneral getInstance()
    {
        return general;
    }

    public static ConfigGeneral getInstance(InputStream file, ServletContext sc)
    {
        if (general == null)
        {
            Yaml yaml = new Yaml();
            general = (ConfigGeneral) yaml.loadAs(file, ConfigGeneral.class);
        }
        return general;
    }
    private String dateFormat;
    private String simpleDateFormat;

    public String getDateFormat()
    {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat)
    {
        this.dateFormat = dateFormat;
    }
    

    public String getSimpleDateFormat()
    {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(String simpleDateFormat)
    {
        this.simpleDateFormat = simpleDateFormat;
    }

    
}
