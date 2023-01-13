package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alamat_not_valid.*

class AlamatNotValidActivity : AppCompatActivity() {
    var tlf1 = intent.getStringExtra("tlf1")
    var tlf2 = intent.getStringExtra("tlf2")
    var mailAddress = intent.getStringExtra("mailAddress")
    var userId = intent.getStringExtra("userId")
    var agingDate = intent.getStringExtra("agingDate")
    var accountNumber = intent.getStringExtra("accountNumber")
    var statusKonsumen = intent.getStringExtra("statusKonsumen")
    var statusUnit = intent.getStringExtra("statusUnit")
    var statusAlamat = intent.getStringExtra("statusAlamat")
    var bertemuDengan = intent.getStringExtra("bertemuDengan")
    var hasilKunjungan = intent.getStringExtra("hasilKunjungan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_not_valid)

        inpRemark.setText(statusAlamat)

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