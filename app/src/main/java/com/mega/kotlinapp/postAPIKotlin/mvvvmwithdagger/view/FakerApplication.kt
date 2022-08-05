package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view

import android.app.Application
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.di.ApplicationComponent
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

       applicationComponent=DaggerApplicationComponent.builder().build()
    }
}