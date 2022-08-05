package com.mega.kotlinapp.postAPIKotlin.postapimvp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostBodyModel (@SerializedName("stores" ) var stores : String? = null) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<PostBodyModel> {
        override fun createFromParcel(parcel: Parcel): PostBodyModel {
            return PostBodyModel(parcel)
        }

        override fun newArray(size: Int): Array<PostBodyModel?> {
            return arrayOfNulls(size)
        }
    }
}