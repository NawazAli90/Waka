package com.waka.ride.Core.network.constant.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserDTO {

    public UserDTO() {
    }


    @SerializedName("fullName")
    @Expose
    private String fullName;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("emergencyContact")
    @Expose
    private String emergencyContact;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("id")
    @Expose
    private String id;



    public String getUser_fullName ()
    {
        return fullName;
    }


    public String getUser_phone ()
    {
        return phone;
    }


    public String getUser_emergencyContact ()
    {
        return emergencyContact;
    }


    public String getUser_username ()
    {
        return username;
    }


    public String getUser_email ()
    {
        return email;
    }


    public String getUser_id()
    {
        return id;
    }



    @Override
    public String toString()
    {
        return "ClassPojo [user_fullName = "+fullName+", user_phone = "+phone+", user_emergencyContact = "+emergencyContact+", user_email = "+email+", user_id = "+id+"]";
    }

}
