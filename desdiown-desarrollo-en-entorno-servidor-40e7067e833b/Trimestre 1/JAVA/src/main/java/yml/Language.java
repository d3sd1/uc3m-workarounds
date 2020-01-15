package yml;

import java.io.InputStream;
import javax.servlet.ServletContext;
import org.yaml.snakeyaml.Yaml;

public class Language
{

    private static Language lang;

    private Language()
    {

    }

    public static Language getInstance()
    {
        return lang;
    }

    public static Language getInstance(InputStream file, ServletContext sc)
    {
        if (lang == null)
        {
            Yaml yaml = new Yaml();
            lang = (Language) yaml.loadAs(file, Language.class);
        }
        return lang;
    }
    private String dbDisconError;
    private String dbNoChangesError;
    private String dbSqlQueryError;
    private String dbResultSetError;
    private String dbSqlIntegrityError;
    private String dbConError;

    private String nullPointerError;
    private String numberFormatError;
    private String parseDateError;
    private String dateFormatError;
    private String loginError;
    private String userNotActiveError;
    private String userMailDuplicatedError;
    private String userActivationFailError;
    private String userActivateGenericError;
    private String userActivateExpiredError;
    private String genericError;

    public String getDbDisconError()
    {
        return dbDisconError;
    }

    public void setDbDisconError(String dbDisconError)
    {
        this.dbDisconError = dbDisconError;
    }

    public String getDbNoChangesError()
    {
        return dbNoChangesError;
    }

    public void setDbNoChangesError(String dbNoChangesError)
    {
        this.dbNoChangesError = dbNoChangesError;
    }

    public String getDbSqlQueryError()
    {
        return dbSqlQueryError;
    }

    public void setDbSqlQueryError(String dbSqlQueryError)
    {
        this.dbSqlQueryError = dbSqlQueryError;
    }

    public String getDbResultSetError()
    {
        return dbResultSetError;
    }

    public void setDbResultSetError(String dbResultSetError)
    {
        this.dbResultSetError = dbResultSetError;
    }

    public String getDbSqlIntegrityError()
    {
        return dbSqlIntegrityError;
    }

    public void setDbSqlIntegrityError(String dbSqlIntegrityError)
    {
        this.dbSqlIntegrityError = dbSqlIntegrityError;
    }

    public String getDbConError()
    {
        return dbConError;
    }

    public void setDbConError(String dbConError)
    {
        this.dbConError = dbConError;
    }

    public String getNullPointerError()
    {
        return nullPointerError;
    }

    public void setNullPointerError(String nullPointerError)
    {
        this.nullPointerError = nullPointerError;
    }

    public String getNumberFormatError()
    {
        return numberFormatError;
    }

    public void setNumberFormatError(String numberFormatError)
    {
        this.numberFormatError = numberFormatError;
    }

    public String getParseDateError()
    {
        return parseDateError;
    }

    public void setParseDateError(String parseDateError)
    {
        this.parseDateError = parseDateError;
    }

    public String getDateFormatError()
    {
        return dateFormatError;
    }

    public void setDateFormatError(String dateFormatError)
    {
        this.dateFormatError = dateFormatError;
    }

    public String getLoginError()
    {
        return loginError;
    }

    public void setLoginError(String loginError)
    {
        this.loginError = loginError;
    }

    public String getUserNotActiveError()
    {
        return userNotActiveError;
    }

    public void setUserNotActiveError(String userNotActiveError)
    {
        this.userNotActiveError = userNotActiveError;
    }

    public String getUserMailDuplicatedError()
    {
        return userMailDuplicatedError;
    }

    public void setUserMailDuplicatedError(String userMailDuplicatedError)
    {
        this.userMailDuplicatedError = userMailDuplicatedError;
    }

    public String getUserActivationFailError()
    {
        return userActivationFailError;
    }

    public void setUserActivationFailError(String userActivationFailError)
    {
        this.userActivationFailError = userActivationFailError;
    }

    public String getUserActivateGenericError()
    {
        return userActivateGenericError;
    }

    public void setUserActivateGenericError(String userActivateGenericError)
    {
        this.userActivateGenericError = userActivateGenericError;
    }

    public String getUserActivateExpiredError()
    {
        return userActivateExpiredError;
    }

    public void setUserActivateExpiredError(String userActivateExpiredError)
    {
        this.userActivateExpiredError = userActivateExpiredError;
    }

    public String getGenericError()
    {
        return genericError;
    }

    public void setGenericError(String genericError)
    {
        this.genericError = genericError;
    }

    

}
