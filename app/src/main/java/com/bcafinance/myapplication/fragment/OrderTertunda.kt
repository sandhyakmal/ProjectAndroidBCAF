package com.bcafinance.myapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bcafinance.myapplication.MainActivity
import com.bcafinance.myapplication.R
import com.bcafinance.myapplication.TertundaActivity
import com.bcafinance.myapplication.adapter.TertundaAdapter
import com.bcafinance.myapplication.database.KunjunganLocalDB
import com.bcafinance.myapplication.model.DataItem
import com.bcafinance.myapplication.model.DataKunjunganLocal
import com.bcafinance.myapplication.model.OrderDetailResponse
import com.example.projectjuara.ICallBackNetwork
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem
import kotlinx.android.synthetic.main.fragment_order_tertunda.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderTertunda.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderTertunda : Fragment(), ICallBackNetwork {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_order_tertunda, container, false)
        (activity as TertundaActivity).loadData()
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderTertunda.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderTertunda().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    lateinit var dataOrder :List<DataItem>
    lateinit var dataKunjungan :List<DataKunjunganLocal>
    override fun onFinishOrder(data: List<DataItem>) {

    }

    override fun onFinishKunjungan(data: List<DataKunjunganLocal>) {
        dataKunjungan = data
        var adapterx = TertundaAdapter()
        adapterx.data = data

        recyclerTertunda.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterx
        }
    }

    override fun onFinishDetailOrder(data: OrderDetailResponse) {
        TODO("Not yet implemented")
    }

    override fun onFinish(data: List<SearchItem>) {
        TODO("Not yet implemented")
    }

    override fun onFinishDetail(data: OMDBDetailResponse) {
        TODO("Not yet implemented")
    }

    override fun onFailed() {
        TODO("Not yet implemented")
    }
}