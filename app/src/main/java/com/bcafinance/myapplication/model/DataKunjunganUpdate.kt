package com.bcafinance.myapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataKunjunganUpdate(
    @field:SerializedName("id")
    val accountId: String? = null,

    @field:SerializedName("accountNumber")
    val accountNumber: String? = null,

    @field:SerializedName("mailAddress")
    val mailAddress: String? = null,

    @field:SerializedName("phoneNumber1")
    val phoneNumber1: String? = null,

    @field:SerializedName("phoneNumber2")
    val phoneNumber2: String? = null,

    @field:SerializedName("modifiedBy")
    val modifiedBy: Int? = null
):Parcelable
