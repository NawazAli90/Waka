package com.waka.ride.retrofit;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.waka.ride.Core.network.constant.NetworkConstant;
public class RetrofitService {
    private Context context;

    public RetrofitService(Context context) {
        this.context = context;
    }

    public  <S> S createService(Class<S> serviceClass){
        //String baseURL = Utils.getBaseURL(context);

        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(NetworkConstant.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);

    }
}
