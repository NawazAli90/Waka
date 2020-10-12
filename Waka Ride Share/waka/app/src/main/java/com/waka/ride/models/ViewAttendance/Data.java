package com.waka.ride.models.ViewAttendance;

public class Data {
    private Organization organization;

    private OrganizationType org_type;

    private History history;

    public Organization getOrganization ()
    {
        return organization;
    }

    public void setOrganization (Organization organization)
    {
        this.organization = organization;
    }

    public OrganizationType getOrg_type ()
    {
        return org_type;
    }

    public void setOrg_type (OrganizationType org_type)
    {
        this.org_type = org_type;
    }

    public History getHistory ()
    {
        return history;
    }

    public void setHistory (History history)
    {
        this.history = history;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [organization = "+organization+", org_type = "+org_type+", history = "+history+"]";
    }
}
