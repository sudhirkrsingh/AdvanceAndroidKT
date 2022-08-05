package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.di

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.network.PostAPI
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("COUNTRY", "United Arab Emirates")
                    .addHeader("CITY", "Asab")
                    .addHeader("LANGUAGE", "EN")
                    .addHeader("IS_FILTERED", "FALSE")
                    .addHeader("AUTH_TOKEN", "dfV8ntU+f0cikVRBDBg0CA==")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("DEVICE_ID", "fPMfRtEnRxCjqPUGREJ9NO")
                    .addHeader("ANDROID_DEVICE_ID","5b39185c0342d9f9")
                    .addHeader("accept","application/json")
                    .addHeader("APP_VERSION", "0.1.72")
                    .build()
                chain.proceed(request)
            })
            .addInterceptor(httpLoggingInterceptor)
            .build()

             return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()

    }

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit): PostAPI{
        return retrofit.create(PostAPI::class.java)
    }

    @Singleton
    @Provides
    fun postBody(): PostBodyModel{
        var postBodyModel=PostBodyModel()
        return postBodyModel
    }
}