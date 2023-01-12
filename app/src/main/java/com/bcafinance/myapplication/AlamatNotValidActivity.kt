package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alamat_not_valid.*

class AlamatNotValidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_not_valid)

        btnLanjut2.setOnClickListener{
            if(inpMailAddress.text.toString().equals("") || inpKabKodya.text.toString().equals("") || inpPostalCode.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Data Dahulu!", Toast.LENGTH_LONG).show()
            }
            else{
                intent = Intent(this, TelfonActivity::class.java)
                startActivity(intent)
            }
        }
    }
}