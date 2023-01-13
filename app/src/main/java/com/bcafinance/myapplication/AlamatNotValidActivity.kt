package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alamat_not_valid.*
import kotlinx.android.synthetic.main.activity_inp_kunjungan.*

class AlamatNotValidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        var tlf1 = intent.getStringExtra("tlf1")
//        var tlf2 = intent.getStringExtra("tlf2")
//        var mailAddress = intent.getStringExtra("mailAddress")
//        var userId = intent.getStringExtra("userId")
//        var agingDate = intent.getStringExtra("agingDate")
//        var accountNumber = intent.getStringExtra("accountNumber")
//        var statusKonsumen = intent.getStringExtra("statusKonsumen")
//        var statusUnit = intent.getStringExtra("statusUnit")
//        var statusAlamat = intent.getStringExtra("statusAlamat")
//        var bertemuDengan = intent.getStringExtra("bertemuDengan")
//        var hasilKunjungan = intent.getStringExtra("hasilKunjungan")

        var alamatBaru:String? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_not_valid)

//        inpRemark.setText(statusAlamat)

        btnLanjut2.setOnClickListener{
            if(inpMailAddress.text.toString().equals("") || inpKabKodya.text.toString().equals("") || inpPostalCode.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Data Dahulu!", Toast.LENGTH_LONG).show()
            }
            else{
//                alamatBaru = "${inpMailAddress.text.toString()} ${inpKabKodya.text.toString()} ${inpPostalCode.text.toString()}"
                intent = Intent(this, TelfonActivity::class.java)
//                intent.putExtra("tlf1", tlf1)
//                intent.putExtra("tlf2", tlf2)
//                intent.putExtra("mailAddress", mailAddress)
//                intent.putExtra("userId", userId)
//                intent.putExtra("agingDate", agingDate)
//                intent.putExtra("accountNumber", accountNumber)
//                intent.putExtra("statusKonsumen", txtStatus.selectedItem.toString())
//                intent.putExtra("statusUnit", txtUnit.selectedItem.toString())
//                intent.putExtra("statusAlamat", txtAlamat.selectedItem.toString())
//                intent.putExtra("bertemuDengan", txtBertemu.selectedItem.toString())
//                intent.putExtra("hasilKunjungan", txtHasil.selectedItem.toString())
//                intent.putExtra("alamatBaru", alamatBaru)
                startActivity(intent)
            }
        }
    }
}