package com.waka.ride.retrofit;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Context context;

    public RetrofitService(Context context) {
        this.context = context;
    }

    public  <S> S createService(Class<S> serviceClass){
        //String baseURL = Utils.getBaseURL(context);
        String baseURL = "http://157.230.221.95:310/api/";
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);

    }
}
