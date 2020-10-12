package com.waka.ride.models;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.waka.ride.models.loginResponse.User;

public class Utils {

    public static void setLogin(Context context,boolean isLogin){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("isLogin",0);
        Editor editor = preferences.edit();
        editor.putBoolean("isLogin",isLogin);
        editor.apply();
    }
    public static boolean isLogin(Context context){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("isLogin",0);
        return preferences.getBoolean("isLogin",false);
    }
    public static void setUser(Context context, User user){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("user",0);
        Editor editor = preferences.edit();
        editor.putString("id",user.getUser_id());
        editor.putString("email",user.getUser_email());
        editor.putString("fname",user.getUser_fullname());
        editor.putString("name",user.getUsername());
        editor.putString("status",user.getUser_status());
        editor.apply();
    }
    public static User getUser(Context context){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("user",0);
        String id = preferences.getString("id",null);
        String email = preferences.getString("email",null);
        String fname = preferences.getString("fname",null);
        String lname = preferences.getString("name",null);
        String status = preferences.getString("status","disable");
        User user = new User();
        user.setUser_id(id);
        user.setUser_email(email);
        user.setUser_fullname(fname);
        user.setUsername(lname);
        user.setUser_status(status);
        return user;
    }
    public static void setBaseURL(Context context,String URL){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("url",0);
        Editor editor = preferences.edit();
        editor.putString("url",URL);
        editor.apply();
        new AlertDialog.Builder(context)
                .setTitle("Base URL Changed")
                .setMessage("Base URL changed. Restart your app")
                .setPositiveButton("ok",((dialog, which) -> dialog.dismiss())).show();
    }
    public static String getBaseURL(Context context){
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("url",0);
        return preferences.getString("url",null);
    }
    public static void startDialog(FragmentManager manager, DialogFragment fragment){
        FragmentTransaction ft = manager.beginTransaction();
        Fragment prev = manager.findFragmentByTag("dialog");
        if(prev != null)
        {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        fragment.show(ft, "dialog");
    }
}
