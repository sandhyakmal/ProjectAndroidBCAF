package com.bcafinance.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Index.Order
import com.bcafinance.myapplication.adapter.TertundaAdapter
import com.bcafinance.myapplication.database.KunjunganLocalDB
import com.bcafinance.myapplication.fragment.OrderTertunda
import com.bcafinance.myapplication.model.DataKunjunganLocal
import com.example.projectjuara.fragment.ListOrder
import kotlinx.android.synthetic.main.fragment_order_tertunda.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    fun loadData() {
        GlobalScope.launch {
            val data: List<DataKunjunganLocal> =
                KunjunganLocalDB.getInstance(applicationContext).kunjunganDao().getAll()
            Log.d("Data", data.toString())
            runOnUiThread({
                var adapterx = TertundaAdapter()
                adapterx.data = data
                recyclerTertunda.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = adapterx
                }
                //recyclerView.adapter?.notifyDataSetChanged()
            })
        }
    }
}