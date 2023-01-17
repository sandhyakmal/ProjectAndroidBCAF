package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bcafinance.myapplication.LoginPreference.Constant
import com.bcafinance.myapplication.LoginPreference.PreferenceHelper
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        sharedPref = PreferenceHelper(this)

        txtCollectionName.setText(sharedPref.getString(Constant.PREF_COLLECT_NAME))
        txtTitle.setText(sharedPref.getString(Constant.PREF_TITLE))
        txtCoveran.setText(sharedPref.getString(Constant.PREF_COVERAN))

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MenuUtamaActivity::class.java)
            startActivity(intent)
        })
    }
}
