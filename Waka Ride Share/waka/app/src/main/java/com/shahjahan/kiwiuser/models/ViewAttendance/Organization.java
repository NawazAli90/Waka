package com.shahjahan.kiwiuser.models.ViewAttendance;

public class Organization {
    private String user_email;

    private String user_id;

    private String user_organization;

    private String user_phone;

    private String user_fullname;

    private String username;

    public String getUser_email ()
    {
        return user_email;
    }

    public void setUser_email (String user_email)
    {
        this.user_email = user_email;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getUser_organization ()
    {
        return user_organization;
    }

    public void setUser_organization (String user_organization)
    {
        this.user_organization = user_organization;
    }

    public String getUser_phone ()
    {
        return user_phone;
    }

    public void setUser_phone (String user_phone)
    {
        this.user_phone = user_phone;
    }

    public String getUser_fullname ()
    {
        return user_fullname;
    }

    public void setUser_fullname (String user_fullname)
    {
        this.user_fullname = user_fullname;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [user_email = "+user_email+", user_id = "+user_id+", user_organization = "+user_organization+", user_phone = "+user_phone+", user_fullname = "+user_fullname+", username = "+username+"]";
    }
}
