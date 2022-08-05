package com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.presentation.viewmodel

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.repo.Repository
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.StoreListModel

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.Stores
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class StoreViewModel(var repository: Repository):ViewModel() {
    val storeList = MutableLiveData<List<Stores>>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    fun getAllStores() {
        //observer subscribing to observable
        val response = repository.getAllStores()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(singleObservable())
    }

    // this is for single type observable
    fun singleObservable(): SingleObserver<StoreListModel> {
        return object : SingleObserver<StoreListModel> {
            override fun onSubscribe(d: Disposable) {
                disposable=d
            }

            override fun onSuccess(data: StoreListModel) {
                storeList.postValue(data.stores)

                Log.v("jfhsd","thread"+Thread.currentThread())

            }

            override fun onError(e: Throwable) {
                // Error or Exception thrown.
            }


        }
    }

//    // this is for normal type observable
//    private fun getCardsListObserver(): Observer<GiftCardModel> {
//        return object : Observer<GiftCardModel> {
//            override fun onSubscribe(d: Disposable) {
//
//                disposable=d
//                Log.v("subs","done")
//            }
//            override fun onNext(t: @NonNull GiftCardModel) { // run on main thread
//                cardList.postValue(t.giftCardResponseList)
//
//            }
//
//            override fun onError(e: Throwable) {}
//            override fun onComplete() {}
//        }
//    }

}


