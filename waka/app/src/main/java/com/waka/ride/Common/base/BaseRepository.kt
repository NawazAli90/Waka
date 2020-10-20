package com.waka.ride.Common.base;


import com.waka.ride.Core.network.constant.retrofitService.RetrofitService;

open class BaseRepository {
    val retrofit = RetrofitService.getInstance()

}