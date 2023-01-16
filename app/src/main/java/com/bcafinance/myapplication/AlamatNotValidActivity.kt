package com.bcafinance.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alamat_not_valid.*
import kotlinx.android.synthetic.main.activity_telfon.*

class AlamatNotValidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var tlf1 = intent.getStringExtra("tlf1")
        var tlf2 = intent.getStringExtra("tlf2")
        var postalCode = intent.getStringExtra("postalCode")
        var mailAddress = intent.getStringExtra("mailAddress")
        var userId = intent.getStringExtra("userId")
        var agingDate = intent.getStringExtra("agingDate")
        var accountNumber = intent.getStringExtra("accountNumber")
        var statusKonsumen = intent.getStringExtra("statusKonsumen")
        var statusUnit = intent.getStringExtra("statusUnit")
        var statusAlamat = intent.getStringExtra("statusAlamat")
        var bertemuDengan = intent.getStringExtra("bertemuDengan")
        var hasilKunjungan = intent.getStringExtra("hasilKunjungan")
        var alamatBaru:String? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_not_valid)

        txtMaillAddress.setText(mailAddress)
//        testing
//        txtMaillAddress.setText("${tlf1}, ${tlf2}, ${postalCode}, ${mailAddress}, ${userId}, ${hasilKunjungan}")

        btnLanjut2.setOnClickListener{
            if(inpMailAddress.text.toString().equals("") || inpKabKodya.text.toString().equals("") || inpPostalCode.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Data Dahulu!", Toast.LENGTH_LONG).show()
            }
            else{
                alamatBaru = "${inpMailAddress.text.toString()} ${inpKabKodya.text.toString()} ${inpPostalCode.text.toString()}"
                intent = Intent(this, TelfonActivity::class.java)
                intent.putExtra("tlf1", tlf1)
                intent.putExtra("tlf2", tlf2)
                intent.putExtra("postalCode", postalCode)
                intent.putExtra("mailAddress", alamatBaru)
                intent.putExtra("userId", userId)
                intent.putExtra("agingDate", agingDate)
                intent.putExtra("accountNumber", accountNumber)
                intent.putExtra("statusKonsumen", statusKonsumen)
                intent.putExtra("statusUnit", statusUnit)
                intent.putExtra("statusAlamat", statusAlamat)
                intent.putExtra("bertemuDengan", bertemuDengan)
                intent.putExtra("hasilKunjungan", hasilKunjungan)
                startActivity(intent)
            }
        }
    }
}