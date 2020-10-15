package com.shahjahan.kiwiuser.models.ViewAttendance;

public class OrganizationType {
    private String parent_id;

    private String created;

    private String name;

    private String modified;

    private String id;

    private String status;

    public String getParent_id ()
    {
        return parent_id;
    }

    public void setParent_id (String parent_id)
    {
        this.parent_id = parent_id;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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
        return "ClassPojo [parent_id = "+parent_id+", created = "+created+", name = "+name+", modified = "+modified+", id = "+id+", status = "+status+"]";
    }
}
