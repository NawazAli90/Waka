package com.waka.ride.retrofit;

import com.waka.ride.models.loginResponse.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    //Login API
    //https://dashboard.kiwisignin.co.nz/api.php?action=login&email=info@cgit.pk&password=123
    @POST("Customers/login")
    default Call<LoginResponse> loginResponse(@Query("username") String username, @Query("password") String password) {
        return null;
    }



}
