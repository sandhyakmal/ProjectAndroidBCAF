package com.bcafinance.myapplication.LoginAPI

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class userRequest {
    @SerializedName("uniqId")
    @Expose
    var uniqId: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("activated")
    @Expose
    var activated: Boolean? = null

    @SerializedName("id")
    @Expose
    var id: String? = null
}