package com.bcafinance.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.bcafinance.myapplication.model.Data
import com.bcafinance.myapplication.model.DataItem
import com.bcafinance.myapplication.model.OrderDetailResponse
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

        NetworkConfig().getServiceUjian().searchOrderbyAccountNumber(accountNumber).enqueue(object : Callback<OrderDetailResponse>{
            override fun onResponse(
                call: Call<OrderDetailResponse>,
                response: Response<OrderDetailResponse>
            ) {
                if(response.body() !=null) {
                    callbackNetwork.onFinishDetailOrder(response.body() as OrderDetailResponse)
                }
            }

            override fun onFailure(call: Call<OrderDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}