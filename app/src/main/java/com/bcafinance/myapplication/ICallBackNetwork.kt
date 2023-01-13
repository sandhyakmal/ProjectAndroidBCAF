package com.example.projectjuara

import com.bcafinance.myapplication.model.DataItem
import com.example.projectjuara.model.OMDBDetailResponse
import com.example.projectjuara.model.SearchItem
import com.bcafinance.myapplication.model.Data

interface ICallBackNetwork {

    fun onFinishOrder(data: List<DataItem>)
    fun onFinish(data: List<SearchItem>)
    fun onFinishDetail(data : OMDBDetailResponse)
    fun onFinishDetailOrder(data : Data)
    fun onFailed()
}