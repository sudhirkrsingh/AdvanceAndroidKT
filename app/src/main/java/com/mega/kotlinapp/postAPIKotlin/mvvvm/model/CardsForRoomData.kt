package com.mega.kotlinapp.postAPIKotlin.mvvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardsForRoomData(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "marketingContent01") var marketingContent01: String?,
    @ColumnInfo(name = "marketingContent02") var marketingContent02: String?,
    @ColumnInfo(name = "giftCardName") var giftCardName:String?
)