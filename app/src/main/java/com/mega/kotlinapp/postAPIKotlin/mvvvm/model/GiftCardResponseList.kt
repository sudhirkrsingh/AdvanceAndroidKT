package com.mega.kotlinapp.postAPIKotlin.mvvvm.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GiftCardResponseList (

    @SerializedName("productType"             ) var productType             : String? = null,
    @SerializedName("giftCardCode"            ) var giftCardCode            : String? = null,
    @SerializedName("currencyCode"            ) var currencyCode            : String? = null,
    @SerializedName("faceValue"               ) var faceValue               : Int?    = null,
    @SerializedName("activationMaxAmt"        ) var activationMaxAmt        : Int?    = null,
    @SerializedName("activationMinAmt"        ) var activationMinAmt        : Int?    = null,
    @SerializedName("allowedActivate"         ) var allowedActivate         : Int?    = null,
    @SerializedName("allowedReload"           ) var allowedReload           : Int?    = null,
    @SerializedName("allowedRedeem"           ) var allowedRedeem           : Int?    = null,
    @SerializedName("isFixValue"              ) var isFixValue              : Int?    = null,
    @SerializedName("giftCardName"            ) var giftCardName            : String? = null,
    @SerializedName("termAndCondition"        ) var termAndCondition        : String? = null,
    @SerializedName("giftCardImageUrl"        ) var giftCardImageUrl        : String? = null,
    @SerializedName("description"             ) var description             : String? = null,
    @SerializedName("marketingContent01"      ) var marketingContent01      : String? = null,
    @SerializedName("marketingContent02"      ) var marketingContent02      : String? = null,
    @SerializedName("giftCardStatus"          ) var giftCardStatus          : String? = null,
    @SerializedName("barcodeNumber"           ) var barcodeNumber           : String? = null,
    @SerializedName("giftCardPurchaseType"    ) var giftCardPurchaseType    : String? = null,
    @SerializedName("purchaseContent"         ) var purchaseContent         : String? = null,
    @SerializedName("denominationAmount01"    ) var denominationAmount01    : Int?    = null,
    @SerializedName("denominationAmount02"    ) var denominationAmount02    : Int?    = null,
    @SerializedName("mobileNumber"            ) var mobileNumber            : String? = null,
    @SerializedName("activationAmount"        ) var activationAmount        : Int?    = null,
    @SerializedName("referenceNumber"         ) var referenceNumber         : String? = null,
    @SerializedName("expiryDate"              ) var expiryDate              : String? = null,
    @SerializedName("purchaseDate"            ) var purchaseDate            : String? = null,
    @SerializedName("latestBalance"           ) var latestBalance           : String? = null,
    @SerializedName("sharedWith"              ) var sharedWith              : String? = null,
    @SerializedName("giftedBy"                ) var giftedBy                : String? = null,
    @SerializedName("activationBarcodeNumber" ) var activationBarcodeNumber : String? = null,
    @SerializedName("balanceBarcodeNumber"    ) var balanceBarcodeNumber    : String? = null,
    @SerializedName("status"                  ) var status                  : String? = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
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
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(productType)
        parcel.writeString(giftCardCode)
        parcel.writeString(currencyCode)
        parcel.writeValue(faceValue)
        parcel.writeValue(activationMaxAmt)
        parcel.writeValue(activationMinAmt)
        parcel.writeValue(allowedActivate)
        parcel.writeValue(allowedReload)
        parcel.writeValue(allowedRedeem)
        parcel.writeValue(isFixValue)
        parcel.writeString(giftCardName)
        parcel.writeString(termAndCondition)
        parcel.writeString(giftCardImageUrl)
        parcel.writeString(description)
        parcel.writeString(marketingContent01)
        parcel.writeString(marketingContent02)
        parcel.writeString(giftCardStatus)
        parcel.writeString(barcodeNumber)
        parcel.writeString(giftCardPurchaseType)
        parcel.writeString(purchaseContent)
        parcel.writeValue(denominationAmount01)
        parcel.writeValue(denominationAmount02)
        parcel.writeString(mobileNumber)
        parcel.writeValue(activationAmount)
        parcel.writeString(referenceNumber)
        parcel.writeString(expiryDate)
        parcel.writeString(purchaseDate)
        parcel.writeString(latestBalance)
        parcel.writeString(sharedWith)
        parcel.writeString(giftedBy)
        parcel.writeString(activationBarcodeNumber)
        parcel.writeString(balanceBarcodeNumber)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GiftCardResponseList> {
        override fun createFromParcel(parcel: Parcel): GiftCardResponseList {
            return GiftCardResponseList(parcel)
        }

        override fun newArray(size: Int): Array<GiftCardResponseList?> {
            return arrayOfNulls(size)
        }
    }
}