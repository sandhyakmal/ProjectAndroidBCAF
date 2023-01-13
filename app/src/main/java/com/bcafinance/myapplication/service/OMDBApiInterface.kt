package com.bcafinance.myapplication.service

import com.bcafinance.myapplication.model.DataKunjungan
import com.bcafinance.myapplication.model.ResponseDataKunjungan
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OMDBApiInterface {

    @POST("/api/v1/kunjungan")
    fun sendKunjungan(@Body dataKunjungan: DataKunjungan): Call<ResponseDataKunjungan>
}