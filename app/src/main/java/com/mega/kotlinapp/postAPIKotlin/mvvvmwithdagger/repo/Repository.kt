package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.repo

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.network.PostAPI
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view.FakerApplication
import javax.inject.Inject

class Repository @Inject constructor(private val postAPI: PostAPI,private val body:PostBodyModel) {
    fun getAllStores() = postAPI.postData(body)
//    fun getAllStores(body: PostBodyModel) = postAPI.postData(body)

}