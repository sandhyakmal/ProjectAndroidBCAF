package com.bcafinance.myapplication

import com.bcafinance.myapplication.model.OMDBDetailResponse
import com.bcafinance.myapplication.model.SearchItem

interface ICallBackNetwork {

    fun onFinish(data :List<SearchItem>)
    fun onFinishDetail(data : OMDBDetailResponse)
    fun onFailed()
}