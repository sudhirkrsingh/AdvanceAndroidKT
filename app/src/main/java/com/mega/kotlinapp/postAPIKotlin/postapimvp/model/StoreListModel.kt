package com.mega.kotlinapp.postAPIKotlin.postapimvp.model

import com.google.gson.annotations.SerializedName

data class StoreListModel(@SerializedName("stores" ) var stores : ArrayList<Stores> = arrayListOf())

