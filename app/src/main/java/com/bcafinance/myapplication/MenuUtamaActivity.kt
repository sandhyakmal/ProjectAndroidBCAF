package com.bcafinance.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcafinance.myapplication.LoginPreference.Constant
import com.bcafinance.myapplication.LoginPreference.PreferenceHelper
import com.bcafinance.myapplication.adapter.OrderAdapter
import com.bcafinance.myapplication.fragment.OrderTertunda
import com.bcafinance.myapplication.model.DataItem
import com.google.android.material.internal.ContextUtils.getActivity
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_list_order.*
import kotlinx.android.synthetic.main.fragment_list_order.view.*

class MenuUtamaActivity : AppCompatActivity() {

    lateinit var sharedPref: PreferenceHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        sharedPref = PreferenceHelper(this)



//        textView4.setText(sharedPref.getString(Constant.PREF_COVERAN))

        cardOrder.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

        cardChangePass.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ChangePasswordActivity::class.java)
            startActivity(intent)
        })

        cardLogout.setOnClickListener(View.OnClickListener {
            sharedPref.clear()
            Toast.makeText(applicationContext, "Logout Succes", Toast.LENGTH_LONG).show()

            moveIntent()
        })

        cardTertunda.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,TertundaActivity::class.java)
            startActivity(intent)
        })

        //count
        txtCountOrder.setText(sharedPref.getString(Constant.PREF_TOTAL_ORDER))

        textView24.setText(sharedPref.getString(Constant.PREF_TOTAL_ORDER))



    }

    private fun moveIntent(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}