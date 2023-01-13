package com.bcafinance.myapplication.LoginAPI

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class userResponse {
    @SerializedName("data")
    @Expose
    var data: User? = null

    class User {
        @SerializedName("collectName")
        @Expose
        var collectName: String? = null

        @SerializedName("coveran")
        @Expose
        var coveran: String? = null

        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("activated")
        @Expose
        var activated: Boolean? = null
    }
}