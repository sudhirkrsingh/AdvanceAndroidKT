package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Stores (
    @SerializedName("countryId"                  ) var countryId                  : Int?              = null,
    @SerializedName("countryName"                ) var countryName                : String?           = null,
    @SerializedName("cityId"                     ) var cityId                     : Int?              = null,
    @SerializedName("cityName"                   ) var cityName                   : String?           = null,
    @SerializedName("locataion"                  ) var locataion                  : String?           = null,
    @SerializedName("mallId"                     ) var mallId                     : Int?              = null,
    @SerializedName("mallName"                   ) var mallName                   : String?           = null,
    @SerializedName("storeId"                    ) var storeId                    : Int?              = null,
    @SerializedName("brandId"                    ) var brandId                    : Int?              = null,
    @SerializedName("brandName"                  ) var brandName                  : String?           = null,
    @SerializedName("brandCode"                  ) var brandCode                  : String?           = null,
    @SerializedName("storeName"                  ) var storeName                  : String?           = null,
    @SerializedName("storeAddress"               ) var storeAddress               : String?           = null,
    @SerializedName("storeImageUrl"              ) var storeImageUrl              : String?           = null,
    @SerializedName("contactPerson"              ) var contactPerson              : String?           = null,
    @SerializedName("contactNumber"              ) var contactNumber              : String?           = null,
    @SerializedName("videoUrl"                   ) var videoUrl                   : String?           = null,
    @SerializedName("brandIconUrl"               ) var brandIconUrl               : String?           = null,
    @SerializedName("storeWall"                  ) var storeWall                  : Boolean?          = null,
    @SerializedName("lifeStyleProducts"          ) var lifeStyleProducts          : Boolean?          = null,
    @SerializedName("lifeStyleProductsImagePath" ) var lifeStyleProductsImagePath : String?           = null,
    @SerializedName("storeImages"                ) var storeImages                : ArrayList<String> = arrayListOf(),
    @SerializedName("mrBrandId"                  ) var mrBrandId                  : Int?              = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        TODO("storeImages"),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Stores> {
        override fun createFromParcel(parcel: Parcel): Stores {
            return Stores(parcel)
        }

        override fun newArray(size: Int): Array<Stores?> {
            return arrayOfNulls(size)
        }
    }
}