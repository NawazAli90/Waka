package com.waka.ride.models.loginResponse;

public class LoginResponse {
    private String msg;

    private int sts;

    private User users_details;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public int getSts ()
    {
        return sts;
    }

    public void setSts (int sts)
    {
        this.sts = sts;
    }

    public User getDetails ()
    {
        return users_details;
    }

    public void setDetails (User users_details)
    {
        this.users_details = users_details;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", sts = "+sts+", details = "+users_details+"]";
    }
}
