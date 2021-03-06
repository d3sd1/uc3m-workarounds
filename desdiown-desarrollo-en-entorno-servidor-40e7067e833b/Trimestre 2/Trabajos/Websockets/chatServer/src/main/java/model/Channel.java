package model;

public class Channel {
    private int id;
    private String name;
    private int admin_id;
    private String password;
    private boolean actualUserHasPermissions;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAdmin_id()
    {
        return admin_id;
    }

    public void setAdmin_id(int admin_id)
    {
        this.admin_id = admin_id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean getActualUserHasPermissions()
    {
        return actualUserHasPermissions;
    }

    public void setActualUserHasPermissions(boolean actualUserHasPermissions)
    {
        this.actualUserHasPermissions = actualUserHasPermissions;
    }

}
