package com.example.projectjuara.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bcafinance.myapplication.InpKunjunganActivity
import com.bcafinance.myapplication.R
import com.example.projectjuara.ICallBackNetwork
import com.bcafinance.myapplication.MainActivity
import com.bcafinance.myapplication.model.Data
import com.bcafinance.myapplication.model.DataItem
import com.bcafinance.myapplication.model.OrderDetailResponse
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem
import kotlinx.android.synthetic.main.fragment_detail_order.*
import kotlinx.android.synthetic.main.fragment_detail_order.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailOrder.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailOrder : Fragment(), ICallBackNetwork {
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
        val view = inflater.inflate(R.layout.fragment_detail_order, container, false)
        (context as MainActivity).searchOrderbyAccountNumber(param1.toString(),this)

        view.btnInputKunjungan.setOnClickListener(View.OnClickListener {
            val intent = Intent (getActivity(), InpKunjunganActivity::class.java)
            getActivity()?.startActivity(intent)
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailOrder.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailOrder().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onFinishOrder(datas: List<DataItem>) {
        TODO("Not yet implemented")
    }

    override fun onFinish(data: List<SearchItem>) {
        TODO("Not yet implemented")
    }

    override fun onFinishDetail(data: OMDBDetailResponse) {

    }

    override fun onFinishDetailOrder(data: OrderDetailResponse) {
        txtCustomer.setText(data.data?.name)
        txtTypes.setText(data.data?.type)
        txtAccounts.setText(data.data?.accountNumber)
        txtSpouseName.setText(data.data?.spouseName)
        txtAddressKTP.setText(data.data?.ktpAddress)
        txtAddressHome.setText(data.data?.homeAddress)
        txtMailAddress.setText(data.data?.mailAddress)
    }

    override fun onFailed() {
        TODO("Not yet implemented")
    }
}