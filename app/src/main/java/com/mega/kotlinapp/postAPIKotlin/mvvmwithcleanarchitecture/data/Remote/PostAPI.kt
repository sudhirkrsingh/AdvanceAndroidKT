package com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.data.Remote

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.StoreListModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.utils.Constants
import io.reactivex.rxjava3.core.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface PostAPI {

    @POST("cans/tt/rest/api/sec/v4/MallStores.json/37907")
    fun postData( @Body postBodyModel: PostBodyModel): Single<StoreListModel>
//    companion object{
//
//        private var retrofit: Retrofit? = null
//
//        fun postBody(): Retrofit? {
//            if (retrofit == null) {
//                val httpLoggingInterceptor = HttpLoggingInterceptor()
//                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//                val client: OkHttpClient = OkHttpClient.Builder()
//                    .addInterceptor(Interceptor { chain: Interceptor.Chain ->
//                        val request = chain.request()
//                            .newBuilder()
//                            .addHeader("COUNTRY", "United Arab Emirates")
//                            .addHeader("CITY", "Asab")
//                            .addHeader("LANGUAGE", "EN")
//                            .addHeader("IS_FILTERED", "FALSE")
//                            .addHeader("AUTH_TOKEN", "dfV8ntU+f0cikVRBDBg0CA==")
//                            .addHeader("Content-Type", "application/json")
//                            .addHeader("DEVICE_ID", "fPMfRtEnRxCjqPUGREJ9NO")
//                            .addHeader("ANDROID_DEVICE_ID","5b39185c0342d9f9")
//                            .addHeader("accept","application/json")
//                            .addHeader("APP_VERSION", "0.1.72")
//                            .build()
//                        chain.proceed(request)
//                    })
//                    .addInterceptor(httpLoggingInterceptor)
//                    .build()
//                retrofit = Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                    .client(client)
//                    .build()
//            }
//            return retrofit
//        }
//    }

}