package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.di

import com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.core.di.NetModule
import com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.presentation.view.fragment.CleanArchFragment
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view.StoreFragment
import com.mega.kotlinapp.postAPIKotlin.postapimvp.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent  {

    fun inject(cleanArchFragment: CleanArchFragment)
    fun inject(storeFragment:StoreFragment)
    fun inject(mainActivity: MainActivity)
}