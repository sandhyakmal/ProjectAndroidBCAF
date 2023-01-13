package com.bcafinance.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bcafinance.myapplication.InpKunjunganActivity
import com.bcafinance.myapplication.R
import com.bcafinance.myapplication.ICallBackNetwork
import com.bcafinance.myapplication.MainActivity
import com.bcafinance.myapplication.model.OMDBDetailResponse
import com.bcafinance.myapplication.model.SearchItem
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
    private var tlf1:String? = null
    private var tlf2:String? = null
    private var mailAddress:String? = null
    private var userId:String? = null
    private var agingDate:String? = null
    private var accountNumber:String? = null

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
        (context as MainActivity).searchMoviebyId(param1.toString(),this)

        view.btnInputKunjungan.setOnClickListener(View.OnClickListener {
            val intent = Intent (getActivity(), InpKunjunganActivity::class.java)
            intent.putExtra("tlf1", tlf1)
            intent.putExtra("tlf2", tlf2)
            intent.putExtra("mailAddress", mailAddress)
            intent.putExtra("userId", userId)
            intent.putExtra("agingDate", agingDate)
            intent.putExtra("accountNumber", accountNumber)

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

    override fun onFinish(data: List<SearchItem>) {
        TODO("Not yet implemented")
    }

    override fun onFinishDetail(data: OMDBDetailResponse) {
        tlf1 = data.imdbID
        txtCustomer.setText(data.title)
        txtTypes.setText(data.type)
        txtAccounts.setText(data.imdbID)
        txtSpouseName.setText(data.director)
        txtAddressKTP.setText(data.plot)
        txtAddressHome.setText(data.plot)
        txtMailAddress.setText(data.plot)

    }

    override fun onFailed() {
        TODO("Not yet implemented")
    }
}