package com.waka.ride.retrofit;

import android.content.Context;

import com.waka.ride.models.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Context context;

    public RetrofitService(Context context) {
        this.context = context;
    }

    public  <S> S createService(Class<S> serviceClass){
        //String baseURL = Utils.getBaseURL(context);
        String baseURL = "https://dashboard.kiwisignin.co.nz/";
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
        /*Retrofit retrofit;
        if(baseURL != null ){
            if(baseURL.isEmpty()){
                baseURL = "http://new.bidecinfinity.com/";
                Utils.setBaseURL(context, baseURL);
            }
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(serviceClass);
        }else {
            baseURL = "http://new.bidecinfinity.com/";
            Utils.setBaseURL(context, baseURL);
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(serviceClass);
        }*/
    }
}
