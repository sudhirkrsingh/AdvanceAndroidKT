package com.mega.kotlinapp.postAPIKotlin.mvvvm.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object GetAPI {

    private const val BASE_URL: String ="https://rpcauat-api.reciproci.com/"
    private var retrofit: Retrofit? = null

    fun getCards(): Retrofit? {
        if (retrofit == null) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("COUNTRY", "United Arab Emirates")
                        .addHeader("CITY", "Dubai")
                        .addHeader("LANGUAGE", "EN")
                        .addHeader("IS_FILTERED", "FALSE")
                        .addHeader("Authorization","NJ7FkM0RYiRB4iKR5z4HyQ==")
                        .addHeader("AUTH_TOKEN", "NJ7FkM0RYiRB4iKR5z4HyQ==")
                        .addHeader("Content-Type", "application/json")
                        .addHeader("DEVICE_ID", "cw4M6_7CRsO2hRhA9NSyqC")
                        .addHeader("APP_VERSION", "0.1.71")
                        .build()
                    chain.proceed(request)
                })
                .addInterceptor(httpLoggingInterceptor)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build()
        }
        return retrofit
    }
}