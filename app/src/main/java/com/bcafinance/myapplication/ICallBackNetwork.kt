package com.example.projectjuara

import com.bcafinance.myapplication.model.DataItem
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem
import com.bcafinance.myapplication.model.Data
import com.bcafinance.myapplication.model.OrderDetailResponse

interface ICallBackNetwork {

    fun onFinishOrder(data: List<DataItem>)
    fun onFinishDetailOrder(data : OrderDetailResponse)

    fun onFinish(data: List<SearchItem>)
    fun onFinishDetail(data : OMDBDetailResponse)
    fun onFinishDetailorder(data : Data)
    fun onFailed()
}