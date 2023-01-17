package com.bcafinance.myapplication.LoginAPI

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {

    var ip = "192.168.137.1"
    fun getRetroClientInstance() : Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return  Retrofit.Builder()
            .baseUrl("http:${ip}:8080/api/v1/user/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}