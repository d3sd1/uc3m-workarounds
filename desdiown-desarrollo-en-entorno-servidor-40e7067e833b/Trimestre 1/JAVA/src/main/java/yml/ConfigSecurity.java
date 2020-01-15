package yml;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class ConfigSecurity
{

    private static ConfigSecurity security;

    private ConfigSecurity()
    {

    }

    public static ConfigSecurity getInstance()
    {
        return security;
    }

    public static ConfigSecurity getInstance(InputStream file, ServletContext sc)
    {
        if (security == null)
        {
            Yaml yaml = new Yaml();
            security = (ConfigSecurity) yaml.loadAs(file, ConfigSecurity.class);
        }
        return security;
    }

    private int securityLevel;
    private String PBKDF2Algorithm;
    private int saltByteSize;
    private int hashByteSize;
    private int PBKDF2Iterations;

    public int getSecurityLevel()
    {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel)
    {
        this.securityLevel = securityLevel;
    }

    public String getPBKDF2Algorithm()
    {
        return PBKDF2Algorithm;
    }

    public void setPBKDF2Algorithm(String PBKDF2Algorithm)
    {
        this.PBKDF2Algorithm = PBKDF2Algorithm;
    }

    public int getSaltByteSize()
    {
        return saltByteSize;
    }

    public void setSaltByteSize(int saltByteSize)
    {
        this.saltByteSize = saltByteSize;
    }

    public int getHashByteSize()
    {
        return hashByteSize;
    }

    public void setHashByteSize(int hashByteSize)
    {
        this.hashByteSize = hashByteSize;
    }

    public int getPBKDF2Iterations()
    {
        return PBKDF2Iterations;
    }

    public void setPBKDF2Iterations(int PBKDF2Iterations)
    {
        this.PBKDF2Iterations = PBKDF2Iterations;
    }


}
