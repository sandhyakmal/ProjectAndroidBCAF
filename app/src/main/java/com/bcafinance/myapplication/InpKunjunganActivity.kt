package com.bcafinance.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inp_kunjungan.*

class InpKunjunganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inp_kunjungan)
        var tlf1 =  intent.getStringExtra("tlf1")
        var tlf2 =  intent.getStringExtra("tlf2")
        var postalCode = intent.getStringExtra("postalCode")
        var mailAddress = intent.getStringExtra("mailAddress")
        var userId = intent.getStringExtra("userId")
        var agingDate = intent.getStringExtra("agingDate")
        var accountNumber = intent.getStringExtra("accountNumber")

        btnLanjut.setOnClickListener {
            if(txtAlamat.selectedItem.toString().equals("Tidak Sesuai")){
                intent = Intent(this, AlamatNotValidActivity::class.java)
                intent.putExtra("tlf1", tlf1)
                intent.putExtra("tlf2", tlf2)
                intent.putExtra("postalCode", postalCode)
                intent.putExtra("mailAddress", mailAddress)
                intent.putExtra("userId", userId)
                intent.putExtra("agingDate", agingDate)
                intent.putExtra("accountNumber", accountNumber)
                intent.putExtra("statusKonsumen", txtStatus.selectedItem.toString())
                intent.putExtra("statusUnit", txtUnit.selectedItem.toString())
                intent.putExtra("statusAlamat", txtAlamat.selectedItem.toString())
                intent.putExtra("bertemuDengan", txtBertemu.selectedItem.toString())
                intent.putExtra("hasilKunjungan", txtHasil.selectedItem.toString())

                startActivity(intent)
            }else{
                intent = Intent(this, TelfonActivity::class.java)
                intent.putExtra("tlf1", tlf1)
                intent.putExtra("tlf2", tlf2)
                intent.putExtra("postalCode", postalCode)
                intent.putExtra("mailAddress", mailAddress)
                intent.putExtra("userId", userId)
                intent.putExtra("agingDate", agingDate)
                intent.putExtra("accountNumber", accountNumber)
                intent.putExtra("statusKonsumen", txtStatus.selectedItem.toString())
                intent.putExtra("statusUnit", txtUnit.selectedItem.toString())
                intent.putExtra("statusAlamat", txtAlamat.selectedItem.toString())
                intent.putExtra("bertemuDengan", txtBertemu.selectedItem.toString())
                intent.putExtra("hasilKunjungan", txtHasil.selectedItem.toString())

                startActivity(intent)
            }
        }
    }
}