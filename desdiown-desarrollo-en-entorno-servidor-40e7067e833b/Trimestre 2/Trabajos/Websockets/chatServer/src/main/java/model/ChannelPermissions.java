package model;

public class ChannelPermissions {
    private User askingUser;
    private User adminUser;
    private Channel channel;
    private boolean granted;
    private boolean adminOnline;

    public User getAskingUser()
    {
        return askingUser;
    }

    public void setAskingUser(User askingUser)
    {
        this.askingUser = askingUser;
    }

    public User getAdminUser()
    {
        return adminUser;
    }

    public void setAdminUser(User adminUser)
    {
        this.adminUser = adminUser;
    }

    public Channel getChannel()
    {
        return channel;
    }

    public void setChannel(Channel channel)
    {
        this.channel = channel;
    }

    public boolean getGranted()
    {
        return granted;
    }

    public void setGranted(boolean granted)
    {
        this.granted = granted;
    }

    public boolean isAdminOnline()
    {
        return adminOnline;
    }

    public void setAdminOnline(boolean adminOnline)
    {
        this.adminOnline = adminOnline;
    }
    
    
}
