package com.bcafinance.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bcafinance.myapplication.MainActivity
import com.bcafinance.myapplication.R
import com.bcafinance.myapplication.model.DataItem
import com.example.projectjuara.fragment.DetailOrder
import kotlinx.android.synthetic.main.item_order.view.*

class TertundaAdapter : RecyclerView.Adapter<TertundaAdapter.ViewHolder>() {

    var data: List<DataItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
       ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tertunda, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataItem) = with(itemView) {

//            itemView.txtAccount.setText(item.accountNumber)
//            itemView.txtName.setText(item.name)
//            itemView.txtType.setText(item.type)
//
//            this.setOnClickListener(View.OnClickListener {
//
//                    it ->
//                val ft: FragmentTransaction = (context as MainActivity).supportFragmentManager.beginTransaction()
//                ft.replace(R.id.frameFragmen, DetailOrder.newInstance(item.accountNumber.toString(),""),"")
//                    .addToBackStack("list")
//                ft.commit()
//
//            })

        }
    }


}