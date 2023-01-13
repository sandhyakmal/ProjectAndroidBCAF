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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telfon)

            teleponYa.setOnClickListener({
                inpTelepon1Update.isEnabled = true
//                txtPrfx.visibility = View.GONE
//                cardPrefix.visibility = View.GONE
//                txtTlp1.visibility = View.GONE
//                cardTlp1.visibility = View.GONE
            })

            telepon2Ya.setOnClickListener {
                inpTelepon2Update.isEnabled = true
//                txtVwTelpon2.visibility = View.GONE
//                cardTelfon2.visibility = View.GONE
            }

            telefonTidak.setOnClickListener({
                inpTelepon1Update.isEnabled = false
//                cardPrefix.visibility = View.VISIBLE
//                txtTlp1.visibility = View.VISIBLE
//                cardTlp1.visibility = View.VISIBLE
            })

            telefon2Tidak.setOnClickListener {
                inpTelepon1Update.isEnabled = false
//                txtVwTelpon2.visibility = View.VISIBLE
//                cardTelfon2.visibility = View.VISIBLE
            }



        btnLanjut3.setOnClickListener({
            intent = Intent(this, SptActivity::class.java)
            startActivity(intent)
        })
    }
}