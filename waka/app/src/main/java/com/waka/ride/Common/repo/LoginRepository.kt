package com.waka.ride.Common.repo

import androidx.lifecycle.MutableLiveData
import com.waka.ride.Common.base.BaseRepository
import com.waka.ride.Common.callbacks.OnLoginApiResponse
import com.waka.ride.Core.network.constant.response.UserDTO
import com.waka.ride.Core.network.constant.response.UserSessionDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository : BaseRepository() {

    fun getLogin(username: String, password: String, onLoginApiResponse: OnLoginApiResponse) {
        val map = HashMap<String, String>()
        map.put("username",username)
        map.put("password",password)
        val call = retrofit.login(map)
        call.enqueue(object : Callback<UserSessionDTO> {
            override fun onResponse(call: Call<UserSessionDTO>, response: Response<UserSessionDTO>) {
                if (response.isSuccessful) {
                    val dto = response.body()
                    dto?.let {
                        getCustomer(it,onLoginApiResponse)
                }
                } else {
                    onLoginApiResponse.onFailure(response.message())
                }

            }

            override fun onFailure(call: Call<UserSessionDTO>, t: Throwable) {
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