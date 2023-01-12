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
                txtPrfx.visibility = View.INVISIBLE
                cardPrefix.visibility = View.INVISIBLE
                txtTlp1.visibility = View.INVISIBLE
                cardTlp1.visibility = View.INVISIBLE
            })

            telefonTidak.setOnClickListener({
                txtPrfx.visibility = View.VISIBLE
                cardPrefix.visibility = View.VISIBLE
                txtTlp1.visibility = View.VISIBLE
                cardTlp1.visibility = View.VISIBLE
            })

        btnLanjut3.setOnClickListener({
            intent = Intent(this, SptActivity::class.java)
            startActivity(intent)
        })
    }
}