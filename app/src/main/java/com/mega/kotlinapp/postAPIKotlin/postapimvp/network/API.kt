package com.mega.kotlinapp.postAPIKotlin.postapimvp.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class API {

    private val BASE_URL: String ="https://rpcauat-api.reciproci.com/"
    private var retrofit: Retrofit? = null

    fun postBody(androidId: String?): Retrofit? {
        if (retrofit == null) {
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
                        .addHeader("ANDROID_DEVICE_ID", androidId!!)
                        .addHeader("accept", "application/json")
                        .addHeader("APP_VERSION", "0.1.72")
                        .build()
                    chain.proceed(request)
                })
                .addInterceptor(httpLoggingInterceptor)
                .build()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit
    }
}