package com.waka.ride.models;

public class AttendanceResponse {
    private String msg;

    private String sts;

    private String status;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public String getSts ()
    {
        return sts;
    }

    public void setSts (String sts)
    {
        this.sts = sts;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", sts = "+sts+", status = "+status+"]";
    }
}
