package com.bcafinance.myapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class OrderDetailResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("statusKunjungan")
	val statusKunjungan: String? = null,

	@field:SerializedName("ktpAddress")
	val ktpAddress: String? = null,

	@field:SerializedName("coveran")
	val coveran: String? = null,

	@field:SerializedName("postalCode")
	val postalCode: Int? = null,

	@field:SerializedName("phoneNumber1")
	val phoneNumber1: String? = null,

	@field:SerializedName("mailAddress")
	val mailAddress: String? = null,

	@field:SerializedName("phoneNumber2")
	val phoneNumber2: String? = null,

	@field:SerializedName("active")
	val active: Boolean? = null,

	@field:SerializedName("accountNumber")
	val accountNumber: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("priority")
	val priority: Boolean? = null,

	@field:SerializedName("createdDate")
	val createdDate: String? = null,

	@field:SerializedName("createdBy")
	val createdBy: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("modifiedDate")
	val modifiedDate: @RawValue Any? = null,

	@field:SerializedName("modifiedBy")
	val modifiedBy: @RawValue Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("spouseName")
	val spouseName: String? = null,

	@field:SerializedName("agingDate")
	val agingDate: String? = null,

	@field:SerializedName("customer")
	val customer: String? = null,

	@field:SerializedName("homeAddress")
	val homeAddress: String? = null
) : Parcelable
