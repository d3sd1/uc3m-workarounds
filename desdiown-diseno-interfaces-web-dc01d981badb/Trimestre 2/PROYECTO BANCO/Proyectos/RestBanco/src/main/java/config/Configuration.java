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
    private String mysqlHost;
    private String mysqlPort;
    private String mysqlUser;
    private String mysqlPass;
    private String mysqlDatabase;
    private int apiIntervalSeconds;
    private int apiMaxIntervalCalls;
    private String mailFrom;
    private String smtpServer;
    private int smtpPort;
    private String mailPass;
    private int limitActivationMins;

    public static Configuration getConfig()
    {
        return config;
    }

    public static void setConfig(Configuration config)
    {
        Configuration.config = config;
    }

    public String getMysqlHost()
    {
        return mysqlHost;
    }

    public void setMysqlHost(String mysqlHost)
    {
        this.mysqlHost = mysqlHost;
    }

    public String getMysqlPort()
    {
        return mysqlPort;
    }

    public void setMysqlPort(String mysqlPort)
    {
        this.mysqlPort = mysqlPort;
    }

    public String getMysqlUser()
    {
        return mysqlUser;
    }

    public void setMysqlUser(String mysqlUser)
    {
        this.mysqlUser = mysqlUser;
    }

    public String getMysqlPass()
    {
        return mysqlPass;
    }

    public void setMysqlPass(String mysqlPass)
    {
        this.mysqlPass = mysqlPass;
    }

    public String getMysqlDatabase()
    {
        return mysqlDatabase;
    }

    public void setMysqlDatabase(String mysqlDatabase)
    {
        this.mysqlDatabase = mysqlDatabase;
    }

    public int getApiIntervalSeconds()
    {
        return apiIntervalSeconds;
    }

    public void setApiIntervalSeconds(int apiIntervalSeconds)
    {
        this.apiIntervalSeconds = apiIntervalSeconds;
    }

    public int getApiMaxIntervalCalls()
    {
        return apiMaxIntervalCalls;
    }

    public void setApiMaxIntervalCalls(int apiMaxIntervalCalls)
    {
        this.apiMaxIntervalCalls = apiMaxIntervalCalls;
    }

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
