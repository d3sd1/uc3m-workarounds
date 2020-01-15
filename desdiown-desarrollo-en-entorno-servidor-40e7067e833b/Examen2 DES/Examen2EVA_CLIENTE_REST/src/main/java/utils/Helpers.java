package utils;

import com.google.api.client.util.DateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Helpers {
    public String sanitize(String str)
    {
        if(str == null)
        {
            str = "";
        }
        return str;
    }
    public String parameterGetString(String parameter)
    {
        return this.sanitize(parameter);
    }
    public int parameterGetInt(String parameter)
    {
        int number;
        try
        {
            number = Integer.parseInt(this.sanitize(parameter));
        }
        catch(Exception e)
        {
            number = 0;
        }
        return number;
    }
    public Double parameterGetDouble(String parameter)
    {
        double number;
        try
        {
            number = Double.parseDouble(this.sanitize(parameter));
        }
        catch(Exception e)
        {
            number = 0;
        }
        return number;
    }
    public DateTime parameterGetDate(String parameter)
    {
        DateTime date;
        try
        {
            date = new DateTime(new SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH).parse(this.sanitize(parameter)));
        }
        catch(Exception e)
        {
            date = new DateTime(new Date());
        }
        return date;
    }
    public boolean parameterGetBoolean(String parameter)
    {
        return Boolean.parseBoolean(this.sanitize(parameter));
    }
}
