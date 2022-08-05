package com.mega.kotlinapp.postAPIKotlin.postapimvp.presenter

import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.postapimvp.model.StoreListModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ReqAndRes {

    @POST("cans/tt/rest/api/sec/v4/MallStores.json/{mallId}")
    fun postData(@Path("mallId") mallId: Int, @Body postBodyModel: PostBodyModel): Call<StoreListModel>
}