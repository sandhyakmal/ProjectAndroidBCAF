package com.bcafinance.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bcafinance.myapplication.model.DataKunjungan
import com.bcafinance.myapplication.model.ResponseDataKunjungan
import com.bcafinance.myapplication.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_spt.*
import retrofit2.Call
import retrofit2.Response


class SptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spt)

        inpJam.setIs24HourView(true)

        btnSubmit.setOnClickListener {
            postDataKunjungan()
            finish()
            val intent = Intent(this, InpKunjunganActivity::class.java)

//            val intent = Intent(this, MenuUtamaActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

    fun postDataKunjungan(){
        var dataKunjungan = DataKunjungan(
            "Ada",
            "14420",
            "test",
            "14045",
            "14:53",
            "test@email.com",
            "14022",
            "test",
            true,
            "bapakmu",
            2,
            "asdasDFFDsddasd",
            true,
            "ada",
            5,
            "aFDFDsasdas",
            "ada",
            "2022-05-04",
            "ada")
        NetworkConfig().getServiceKunjungan().sendKunjungan(dataKunjungan).enqueue(object : retrofit2.Callback<ResponseDataKunjungan>{
            override fun onResponse(
                call: Call<ResponseDataKunjungan>,
                response: Response<ResponseDataKunjungan>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseDataKunjungan>, t: Throwable) {
                Log.e("error post", t.printStackTrace().toString())
            }
        })
    }
}