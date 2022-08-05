package com.mega.kotlinapp.postAPIKotlin.mvvvm.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GiftCardModel (

    @SerializedName("giftCardResponseList" ) var giftCardResponseList : ArrayList<GiftCardResponseList> = arrayListOf(),
    @SerializedName("status"               ) var status               : String?                         = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("giftCardResponseList"),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<GiftCardModel> {
        override fun createFromParcel(parcel: Parcel): GiftCardModel {
            return GiftCardModel(parcel)
        }

        override fun newArray(size: Int): Array<GiftCardModel?> {
            return arrayOfNulls(size)
        }
    }
}
