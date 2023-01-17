package com.bcafinance.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.bcafinance.myapplication.fragment.OrderTerkirim
import com.bcafinance.myapplication.fragment.OrderTertunda
import com.bcafinance.myapplication.model.DataItem
import com.bcafinance.myapplication.model.OrderResponse
import com.example.projectjuara.ICallBackNetwork
import com.example.projectjuara.service.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TerkirimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terkirim)

        showListMovieFragment()
    }

    fun showListMovieFragment(){
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameFragment3, OrderTerkirim.newInstance("",""),"list")
        ft.commit()
    }

    fun searchTerkirim(title:String, callbackNetwork : ICallBackNetwork) {

        var data : List<DataItem>? = null
        NetworkConfig().getServiceUjian().searchTerkirim(title).enqueue(object :
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
}