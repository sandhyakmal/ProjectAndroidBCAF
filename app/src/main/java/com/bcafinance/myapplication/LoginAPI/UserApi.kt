package com.bcafinance.myapplication.LoginAPI

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserApi {
    @POST("login")
    fun login(
        @Body userRequest: userRequest
    ): retrofit2.Call<userResponse>

    //change
    @PUT("update")
    fun changePassword(
        @Body userRequest: userRequest
    ): retrofit2.Call<userResponse>
}