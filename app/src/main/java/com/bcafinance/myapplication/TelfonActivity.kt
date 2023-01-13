package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alamat_not_valid.*
import kotlinx.android.synthetic.main.activity_inp_kunjungan.*
import kotlinx.android.synthetic.main.activity_telfon.*
import kotlinx.android.synthetic.main.activity_telfon.inpRemark

class TelfonActivity : AppCompatActivity() {
        var isBerubah1 = false;
        var isBerubah2 = false;
        override fun onCreate(savedInstanceState: Bundle?) {
//            var tlf1 = intent.getStringExtra("tlf1")
//            var tlf2 = intent.getStringExtra("tlf2")
//            var mailAddress = intent.getStringExtra("mailAddress")
//            var userId = intent.getStringExtra("userId")
//            var agingDate = intent.getStringExtra("agingDate")
//            var accountNumber = intent.getStringExtra("accountNumber")
//            var statusKonsumen = intent.getStringExtra("statusKonsumen")
//            var statusUnit = intent.getStringExtra("statusUnit")
//            var statusAlamat = intent.getStringExtra("statusAlamat")
//            var bertemuDengan = intent.getStringExtra("bertemuDengan")
//            var hasilKunjungan = intent.getStringExtra("hasilKunjungan")
//            var alamatBaru = intent.getStringExtra("alamatBaru")
            var noHpBaru1:String? = null
            var noHpBaru2:String? = null

            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telfon)

            teleponYa.setOnClickListener({
                inpPrefixUpdate.setText("")
                inpPrefixUpdate.isEnabled = false
                inpTelepon1Update.setText("")
                inpTelepon1Update.isEnabled = false
            })

            telefonTidak.setOnClickListener({
                inpPrefixUpdate.isEnabled = true
                inpTelepon1Update.isEnabled = true
                isBerubah1 = true;
            })

            telepon2Ya.setOnClickListener {
                inpTelepon2Update.isEnabled = false
                inpTelepon2Update.setText("")
            }

            telefon2Tidak.setOnClickListener {
                inpTelepon2Update.isEnabled = true
                isBerubah2 = true;
            }

        btnLanjut3.setOnClickListener({
            if(inpRemark.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Keterangan Dahulu!", Toast.LENGTH_LONG).show()
            }else{
                if(isBerubah1 == true && inpTelepon1Update.text.toString().equals("") && inpPrefixUpdate.text.toString().equals("")){
                    Toast.makeText(applicationContext, "Isi Nomor HP Baru Dahulu!", Toast.LENGTH_LONG).show()
                }
                if(isBerubah2 == true && inpTelepon2Update.text.toString().equals("")){
                    Toast.makeText(applicationContext, "Isi Nomor HP Baru Dahulu!", Toast.LENGTH_LONG).show()
                }else{
                    noHpBaru1 = inpTelepon1Update.text.toString()
                    noHpBaru2 = inpTelepon2Update.text.toString()
                    intent = Intent(this, FotoActivity::class.java)
//                    intent.putExtra("tlf1", tlf1)
//                    intent.putExtra("tlf2", tlf2)
//                    intent.putExtra("mailAddress", mailAddress)
//                    intent.putExtra("userId", userId)
//                    intent.putExtra("agingDate", agingDate)
//                    intent.putExtra("accountNumber", accountNumber)
//                    intent.putExtra("statusKonsumen", txtStatus.selectedItem.toString())
//                    intent.putExtra("statusUnit", txtUnit.selectedItem.toString())
//                    intent.putExtra("statusAlamat", txtAlamat.selectedItem.toString())
//                    intent.putExtra("bertemuDengan", txtBertemu.selectedItem.toString())
//                    intent.putExtra("hasilKunjungan", txtHasil.selectedItem.toString())
//                    intent.putExtra("alamatBaru", alamatBaru)
//                    intent.putExtra("noHpBaru1", noHpBaru1)
//                    intent.putExtra("noHpBaru2", noHpBaru2)
                    startActivity(intent)
                }
            }
        })
    }
}