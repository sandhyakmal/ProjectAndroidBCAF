package com.example.projectjuara.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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

    fun getServiceOMDB() = getRetrofit().create(OMDBApiInterface::class.java)


    //UJIAN API
    fun getInterceptorUjian() : OkHttpClient {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient  = OkHttpClient.Builder().addInterceptor(logging).build()

        return  okHttpClient
    }

    fun getRetrofitUjian() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("http://192.168.137.64:8080")
            .client(getInterceptorUjian())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getServiceUjian() = getRetrofitUjian().create(OMDBApiInterface::class.java)


}