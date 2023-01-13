package com.bcafinance.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.bcafinance.myapplication.model.Data
import com.bcafinance.myapplication.model.DataItem
import com.bcafinance.myapplication.model.OrderResponse
import com.example.projectjuara.ICallBackNetwork
import com.example.projectjuara.fragment.DetailOrder
import com.example.projectjuara.fragment.ListOrder
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.OMDBResponse
import com.example.projectjuara.model.SearchItem
import com.example.projectjuara.service.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListMovieFragment()
    }

    fun showListMovieFragment(){
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameFragmen, ListOrder.newInstance("",""),"list")
        ft.commit()
    }

    fun searchOrder(title:String, callbackNetwork : ICallBackNetwork) {

        var data : List<DataItem>? = null
        NetworkConfig().getServiceUjian().searchOrder(title).enqueue(object :
            Callback<OrderResponse> {
            override fun onResponse(call: Call<OrderResponse>, response: Response<OrderResponse>) {
                Log.d("Response OMDB APi search", response.toString())

                if(response.body()?.data!=null) {
                    data = (response.body()?.data as List<DataItem>)
                    callbackNetwork.onFinishOrder(data!!)
                }
            }

            override fun onFailure(call: Call<OrderResponse>, t: Throwable) {
                Log.e("Failed Response", t.message.toString())
                callbackNetwork.onFailed()
            }

        })
    }

    fun searchOrderbyAccountNumber(accountNumber:String, callbackNetwork: DetailOrder) {

        NetworkConfig().getServiceUjian().searchOrderbyAccountNumber(accountNumber).enqueue(object : Callback<Data>{
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                if(response.body() !=null) {
                    callbackNetwork.onFinishDetailOrder(response.body() as Data)
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun searchMovie(title:String, callbackNetwork : ICallBackNetwork) {

        var data : List<SearchItem>? = null
        NetworkConfig().getServiceOMDB().searchMovie(title).enqueue(object :
            Callback<OMDBResponse> {
            override fun onResponse(call: Call<OMDBResponse>, response: Response<OMDBResponse>) {
                Log.d("Response OMDB APi search", response.toString())

                if(response.body()?.search!=null) {
                    data = (response.body()?.search as List<SearchItem>)
                    callbackNetwork.onFinish(data!!)
                }
            }

            override fun onFailure(call: Call<OMDBResponse>, t: Throwable) {
                Log.e("Failed Response", t.message.toString())
                callbackNetwork.onFailed()
            }

        })
    }

    fun searchMoviebyId(idMovie:String, callbackNetwork: DetailOrder) {

        NetworkConfig().getServiceOMDB().searchMoviebyId(idMovie).enqueue(object : Callback<OMDBDetailResponse>{
            override fun onResponse(
                call: Call<OMDBDetailResponse>,
                response: Response<OMDBDetailResponse>
            ) {
                if(response.body() !=null) {
                    callbackNetwork.onFinishDetail(response.body()as OMDBDetailResponse)
                }
            }

            override fun onFailure(call: Call<OMDBDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}