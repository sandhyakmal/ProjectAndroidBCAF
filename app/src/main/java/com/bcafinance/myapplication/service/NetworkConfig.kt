package com.example.projectjuara.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkConfig {
    var ip = "192.168.137.1"

    //UJIAN API
    fun getInterceptorUjian() : OkHttpClient {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient  = OkHttpClient.Builder().addInterceptor(logging).build()

        return  okHttpClient
    }

    fun getRetrofitUjian() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("http://${ip}:8080")
            .client(getInterceptorUjian())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitKunjungan(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://${ip}:8080")
            .client(getInterceptorUjian())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getServiceUjian() = getRetrofitUjian().create(OMDBApiInterface::class.java)
    fun getServiceKunjungan() = getRetrofitKunjungan().create(OMDBApiInterface::class.java)
}