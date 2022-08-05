package com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.repo.Repository
import javax.inject.Inject

class StoreViewModelFactory @Inject constructor(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
            StoreViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}