package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inp_kunjungan.*

class InpKunjunganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inp_kunjungan)

        btnLanjut.setOnClickListener {
            if(txtAlamat.selectedItem.toString().equals("Tidak")){
                intent = Intent(this, AlamatNotValidActivity::class.java)
                startActivity(intent)
            }else{
                intent = Intent(this, TelfonActivity::class.java)
                startActivity(intent)
            }
        }
    }
}