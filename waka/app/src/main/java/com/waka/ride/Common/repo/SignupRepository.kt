package com.waka.ride.Common.repo

import androidx.lifecycle.MutableLiveData
import com.waka.ride.Common.base.BaseRepository
import com.waka.ride.Common.callbacks.OnLoginApiResponse
import com.waka.ride.Core.network.constant.response.UserDTO
import com.waka.ride.Core.network.constant.response.UserSessionDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupRepository : BaseRepository() {

    fun signup(username: String, password: String, phoneNo:String, email:String, fullName:String, onLoginApiResponse: OnLoginApiResponse) {
        val map = HashMap<String, String>()
        map.put("username",username)
        map.put("password",password)
        map.put("phone",phoneNo)
        map.put("fullName",fullName)
        map.put("email",email)

        val call = retrofit.signup(map)
        call.enqueue(object : Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                if (response.isSuccessful) {
                    val dto = response.body()
                    dto?.let {
                        onLoginApiResponse.onResponse(it)
                    }
                } else {
                    onLoginApiResponse.onFailure(response.message())
                }

            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                onLoginApiResponse.onFailure(t.message!!)
            }


        })
    }

     fun getCustomer(userSession: UserSessionDTO, onLoginApiResponse: OnLoginApiResponse) {


        val call = retrofit.getCustomer(userSession.userId,userSession.id)
         call.enqueue(object : Callback<UserDTO> {


             override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {

                 if (response.isSuccessful)
                 {
                     val dto = response.body()

                     dto?.let{
                         onLoginApiResponse.onResponse(it)
                     }

                 } else
                 {
                     onLoginApiResponse.onFailure(response.message())
                 }
             }




             override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                 onLoginApiResponse.onFailure(t.message!!)
             }
         })

    }


}