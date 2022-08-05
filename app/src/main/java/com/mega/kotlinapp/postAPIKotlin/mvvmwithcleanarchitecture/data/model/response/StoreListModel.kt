package com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.data.model.response

import com.google.gson.annotations.SerializedName

data class StoreListModel(@SerializedName("stores" ) var stores : ArrayList<Stores> = arrayListOf())

