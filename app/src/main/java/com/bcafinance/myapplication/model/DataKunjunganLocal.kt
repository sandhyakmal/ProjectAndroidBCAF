package com.bcafinance.myapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class DataKunjunganLocal(
    @PrimaryKey(autoGenerate = true) val id:Int,

    @field:SerializedName("hasilKunjungan")
    val hasilKunjungan: String? = null,

    @field:SerializedName("postalCode")
    val postalCode: String? = null,

    @field:SerializedName("diterimaOleh")
    val diterimaOleh: String? = null,

    @field:SerializedName("phoneNumber1")
    val phoneNumber1: String? = null,

    @field:SerializedName("jamDiterima")
    val jamDiterima: String? = null,

    @field:SerializedName("mailAddress")
    val mailAddress: String? = null,

    @field:SerializedName("phoneNumber2")
    val phoneNumber2: String? = null,

    @field:SerializedName("remark")
    val remark: String? = null,

    @field:SerializedName("isActive")
    val isActive: Boolean? = null,

    @field:SerializedName("bertemuDengan")
    val bertemuDengan: String? = null,

    @field:SerializedName("userId")
    val userId: Int? = null,

    @field:SerializedName("fotoRumah")
    val fotoRumah: String? = null,

    @field:SerializedName("isSpt")
    val isSpt: Boolean? = null,

    @field:SerializedName("statusKonsumen")
    val statusKonsumen: String? = null,

    @field:SerializedName("accountId")
    val accountId: Int? = null,

    @field:SerializedName("fotoKtp")
    val fotoKtp: String? = null,

    @field:SerializedName("statusAlamat")
    val statusAlamat: String? = null,

    @field:SerializedName("agingDate")
    val agingDate: String? = null,

    @field:SerializedName("statusUnit")
    val statusUnit: String? = null
):Parcelable