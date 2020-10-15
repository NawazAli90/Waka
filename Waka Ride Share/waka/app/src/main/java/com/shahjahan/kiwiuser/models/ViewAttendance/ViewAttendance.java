package com.shahjahan.kiwiuser.models.ViewAttendance;

public class ViewAttendance {
    private String msg;

    private String sts;

    private Data[] data;

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

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", sts = "+sts+", data = "+data+"]";
    }
}
