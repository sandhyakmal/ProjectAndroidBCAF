package com.bcafinance.myapplication.service

import com.bcafinance.myapplication.service.OMDBApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {
    //OMDB API
    fun getInterceptor() : OkHttpClient {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient  = OkHttpClient.Builder().addInterceptor(logging).build()

        return  okHttpClient
    }
    fun getRetrofit() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    var ip = "192.168.137.64"

    fun getRetrofitKunjungan(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://${ip}:8080")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getServiceOMDB() = getRetrofit().create(OMDBApiInterface::class.java)
    fun getServiceKunjungan() = getRetrofitKunjungan().create(OMDBApiInterface::class.java)

}