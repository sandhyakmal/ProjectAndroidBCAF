package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_telfon.*

    class TelfonActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            var a = intent.getStringExtra("telfon1")

            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telfon)
            txtTelpon1.setText(a)
            teleponYa.setOnClickListener({
                inpPrefixUpdate.setText("")
                inpPrefixUpdate.isEnabled = false
                inpTelepon1Update.setText("")
                inpTelepon1Update.isEnabled = false
            })

            telefonTidak.setOnClickListener({
                inpPrefixUpdate.isEnabled = true
                inpTelepon1Update.isEnabled = true
            })

            telepon2Ya.setOnClickListener {
                inpTelepon2Update.isEnabled = false
                inpTelepon2Update.setText("")
            }

            telefon2Tidak.setOnClickListener {
                inpTelepon2Update.isEnabled = true
            }



        btnLanjut3.setOnClickListener({
            intent = Intent(this, SptActivity::class.java)
            startActivity(intent)
        })
    }
}