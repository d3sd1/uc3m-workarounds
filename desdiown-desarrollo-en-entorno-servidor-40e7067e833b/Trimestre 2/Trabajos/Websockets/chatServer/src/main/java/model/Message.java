package model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Message
{
    private int id;
    private User sender;
    private Object mensaje;
    private boolean save;
    private Timestamp date_sent;
    private int channel_id;
    
    public Message()
    {
        Calendar cal = Calendar.getInstance();
        this.date_sent = new java.sql.Timestamp(cal.getTimeInMillis());
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getSender()
    {
        return sender;
    }

    public void setSender(User sender)
    {
        this.sender = sender;
    }

    public String getMensaje()
    {
        return mensaje.toString();
    }

    public void setMensaje(Object mensaje)
    {
        this.mensaje = mensaje;
    }

    public boolean isSave()
    {
        return save;
    }

    public void setSave(boolean save)
    {
        this.save = save;
    }

    public Timestamp getDate()
    {
        return date_sent;
    }

    public void setDate(Timestamp date)
    {
        this.date_sent = date;
    }

    public void setDate(Date date)
    {
        this.date_sent = new java.sql.Timestamp(date.getTime());
    }

    public int getChannel_id()
    {
        return channel_id;
    }

    public void setChannel_id(int channel_id)
    {
        this.channel_id = channel_id;
    }

    
}