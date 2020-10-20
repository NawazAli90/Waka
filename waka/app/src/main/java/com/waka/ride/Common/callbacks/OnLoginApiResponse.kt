package com.waka.ride.Common.callbacks

import com.waka.ride.Core.network.constant.response.UserDTO


 interface OnLoginApiResponse {
    fun onResponse(model: UserDTO)
    fun onFailure(message: String)

}