package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Constants;

public class DateFilter
{
    private Timestamp beginDate;
    private Timestamp endDate;
    private Channel channel;

    public Timestamp getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = new java.sql.Timestamp(beginDate.getTime());
    }

    public Timestamp getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = new java.sql.Timestamp(endDate.getTime());
    }
    public String getBeginDateFormatted()
    {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(beginDate.getTime());
    }
    public String getEndDateFormatted()
    {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(endDate.getTime());
    }

    public Channel getChannel()
    {
        return channel;
    }

    public void setChannel(Channel channel)
    {
        this.channel = channel;
    }
    
}
