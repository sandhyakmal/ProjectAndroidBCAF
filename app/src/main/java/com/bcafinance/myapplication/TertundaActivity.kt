package com.bcafinance.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.room.Index.Order
import com.bcafinance.myapplication.fragment.OrderTertunda
import com.example.projectjuara.fragment.ListOrder

class TertundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tertunda)

        showListMovieFragment()
    }

    fun showListMovieFragment(){
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameFragment2, OrderTertunda.newInstance("",""),"list")
        ft.commit()
    }
}