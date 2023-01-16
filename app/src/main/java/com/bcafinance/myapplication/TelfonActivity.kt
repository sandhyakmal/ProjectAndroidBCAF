package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_telfon.*

class TelfonActivity : AppCompatActivity() {
    var isBerubah1 = false;
    var isBerubah2 = false;
    var isFilled1 = false
    var isFilled2 = false

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

            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telfon)

//            testing
//            inpRemark.setText("${tlf1}, ${tlf2}, ${mailAddress}")

            teleponYa.setOnClickListener({
                inpPrefixUpdate.setText("")
                inpPrefixUpdate.isEnabled = false
                inpTelepon1Update.setText("")
                inpTelepon1Update.isEnabled = false
                isBerubah1 = false;
                isFilled1 = true
            })

            telefonTidak.setOnClickListener({
                inpPrefixUpdate.isEnabled = true
                inpTelepon1Update.isEnabled = true
                isBerubah1 = true;
                isFilled1 = true
            })

            telepon2Ya.setOnClickListener {
                inpTelepon2Update.isEnabled = false
                inpTelepon2Update.setText("")
                isBerubah2 = false;
                isFilled2 = true
            }

            telefon2Tidak.setOnClickListener {
                inpTelepon2Update.isEnabled = true
                isBerubah2 = true;
                isFilled2 = true
            }

        btnLanjut3.setOnClickListener({
            if(isBerubah1 == true && inpTelepon1Update.text.toString().equals("") && inpPrefixUpdate.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Telefon 1 Baru Dahulu!", Toast.LENGTH_LONG).show()
            }else if(isBerubah2 == true && inpTelepon2Update.text.toString().equals("")){
                Toast.makeText(applicationContext, "Isi Telefon 2 Baru Dahulu!", Toast.LENGTH_LONG).show()
            }else{
                if(inpRemark.text.toString().equals("")){
                    Toast.makeText(applicationContext, "Isi Keterangan Dahulu!", Toast.LENGTH_LONG).show()
                }else if(isFilled1 == false || isFilled2 == false){
                    Toast.makeText(applicationContext, "Isi Validasi Telepon Dahulu!", Toast.LENGTH_SHORT).show()
                } else{
                    intent = Intent(this, FotoActivity::class.java)
                    intent.putExtra("postalCode", postalCode)
                    intent.putExtra("mailAddress", mailAddress)
                    intent.putExtra("userId", userId)
                    intent.putExtra("agingDate", agingDate)
                    intent.putExtra("accountNumber", accountNumber)
                    intent.putExtra("statusKonsumen", statusKonsumen)
                    intent.putExtra("statusUnit", statusUnit)
                    intent.putExtra("statusAlamat", statusAlamat)
                    intent.putExtra("bertemuDengan", bertemuDengan)
                    intent.putExtra("hasilKunjungan", hasilKunjungan)
                    intent.putExtra("remark", inpRemark.text.toString())

                    if(isBerubah1 == true && isBerubah2 == true){
                        intent.putExtra("tlf1", "${inpPrefixUpdate.text.toString()}${inpTelepon1Update.text.toString()}")
                        intent.putExtra("tlf2", inpTelepon2Update.text.toString())
                    }else if(isBerubah1 == true){
                        intent.putExtra("tlf1", "${inpPrefixUpdate.text.toString()} ${inpTelepon1Update.text.toString()}")
                        intent.putExtra("tlf2", tlf2)
                    }else if(isBerubah2 == true){
                        intent.putExtra("tlf2", inpTelepon2Update.text.toString())
                        intent.putExtra("tlf1", tlf1)
                    }else{
                        intent.putExtra("tlf2", tlf2)
                        intent.putExtra("tlf1", tlf1)
                    }
                    startActivity(intent)                }
            }
        })
    }
}