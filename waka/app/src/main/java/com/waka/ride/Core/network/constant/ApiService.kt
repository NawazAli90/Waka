package com.premier.dataProvider.common.network

import com.waka.ride.Core.network.constant.response.UserDTO
import com.waka.ride.Core.network.constant.response.UserSessionDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("Customers/login")
    fun login(@Body body: Map<String, String>): Call<UserSessionDTO>

    @Headers("Content-Type: application/json")
    @GET("Customers/{id}")
     fun getCustomer(@Path("id") id: String, @Header("authorization")auth: String): Call<UserDTO>

    @Headers("Content-Type: application/json")
    @POST("Customers")
    fun signup(@Body body: Map<String, String>): Call<UserDTO>


}