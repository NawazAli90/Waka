package com.waka.ride.models.ViewAttendance;

public class History {
    private String user_id;

    private String dated;

    private String visit_to;

    private String status;

    private String timestamp;

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getDated ()
    {
        return dated;
    }

    public void setDated (String dated)
    {
        this.dated = dated;
    }

    public String getVisit_to ()
    {
        return visit_to;
    }

    public void setVisit_to (String visit_to)
    {
        this.visit_to = visit_to;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [user_id = "+user_id+", dated = "+dated+", visit_to = "+visit_to+", status = "+status+", timestamp = "+timestamp+"]";
    }
}
