package model;

import java.util.List;

public class User
{
    private int id;
    private String email;
    private String pass;
    private boolean online;
    private List<Channel> subscribedChannels;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public boolean getOnline()
    {
        return online;
    }

    public void setOnline(boolean online)
    {
        this.online = online;
    }

    public List<Channel> getSubscribedChannels()
    {
        return subscribedChannels;
    }

    public void setSubscribedChannels(List<Channel> subscribedChannels)
    {
        this.subscribedChannels = subscribedChannels;
    }
    
}
