package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model

import com.google.gson.annotations.SerializedName

data class StoreListModel(@SerializedName("stores" ) var stores : ArrayList<Stores> = arrayListOf())

