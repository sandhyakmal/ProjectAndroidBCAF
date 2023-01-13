package com.bcafinance.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bcafinance.myapplication.model.DataKunjungan
import kotlinx.android.synthetic.main.activity_spt.*
import retrofit2.Call
import retrofit2.Response


class SptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spt)

        inpJam.setIs24HourView(true)

        btnSubmit.setOnClickListener {
            finish()
            val intent = Intent(this, MenuUtamaActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }

//    fun postData(){
//        var dataKunjungan = DataKunjungan(
//            txh,"60d0fe4f5311236168a109f4",
//            txtImg.text.toString(),
//            txtText.text.toString(),
//            txtLikes.text.toString().toInt(),
//            selectedLists)
//        NetworkConfig().getServiceDummy().postData(dummyData).enqueue(object : retrofit2.Callback<ResponsePostDummyData>{
//            override fun onResponse(
//                call: Call<ResponsePostDummyData>,
//                response: Response<ResponsePostDummyData>
//            ) {
//                if(response.isSuccessful){
//                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
//                    txtImg.text.clear()
//                    txtText.text.clear()
//                    txtLikes.text.clear()
//                    txtTags.setText("")
//                    selectedLists.clear()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponsePostDummyData>, t: Throwable) {
//                Log.e("error post", t.printStackTrace().toString())
//            }
//        })
//    }
}