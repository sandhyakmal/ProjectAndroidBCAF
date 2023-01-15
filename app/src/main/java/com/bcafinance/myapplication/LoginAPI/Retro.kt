package com.bcafinance.myapplication.LoginAPI

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance() : Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return  Retrofit.Builder()
            .baseUrl("http:192.168.100.116:8080/api/user/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}