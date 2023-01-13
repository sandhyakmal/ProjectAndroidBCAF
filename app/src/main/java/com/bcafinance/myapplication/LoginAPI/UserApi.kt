package com.bcafinance.myapplication.LoginAPI

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("login")
    fun login(
        @Body userRequest: userRequest
    ): retrofit2.Call<userResponse>


}