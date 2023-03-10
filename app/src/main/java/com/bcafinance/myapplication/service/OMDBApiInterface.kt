package com.example.projectjuara.service

import com.bcafinance.myapplication.model.Data
import com.bcafinance.myapplication.model.OrderDetailResponse
import com.bcafinance.myapplication.model.OrderResponse
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.OMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBApiInterface {
//    http://www.omdbapi.com/?apikey=8a97b2ee&s=Terminator
//    http://192.168.200.166:8080/api/v1/account/for/user?coveran=jakarta
//    http://192.168.200.166:8080/api/v1/account/for/user/detail?accountNumber=1234567890

    @GET("/?apikey=80641bfb")
    fun searchMovie(@Query("s") search:String) : Call<OMDBResponse>

    @GET("/?apikey=80641bfb")
    fun searchMoviebyId(@Query("i") id:String) : Call<OMDBDetailResponse>

    @GET("/api/v1/account/for/user")
    fun searchOrder(@Query("coveran") search:String) : Call<OrderResponse>

    @GET("/api/v1/account/for/user/detail")
    fun searchOrderbyAccountNumber(@Query("accountNumber") account:String) : Call<OrderDetailResponse>



}