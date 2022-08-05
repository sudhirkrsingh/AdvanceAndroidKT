package com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.GiftCardModel
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.GiftCardResponseList
import com.mega.kotlinapp.postAPIKotlin.mvvvm.repo.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class GiftCardViewModel (var repository: Repository) : ViewModel(){
    val cardList = MutableLiveData<List<GiftCardResponseList>>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    fun getAllCards() {
        //observer subscribing to observable
        val response = repository.getAllCards()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(singleObservable())
    }

    // this is for single type observable
    fun singleObservable(): SingleObserver<GiftCardModel> {
        return object : SingleObserver<GiftCardModel> {
            override fun onSubscribe(d: Disposable) {
                disposable=d
            }

            override fun onSuccess(data: GiftCardModel) {

                cardList.postValue(data.giftCardResponseList)
                Log.v("jfhsd","thread"+Thread.currentThread())

            }

            override fun onError(e: Throwable) {
                // Error or Exception thrown.
            }


        }
    }

    // this is for normal type observable
    private fun getCardsListObserver(): Observer<GiftCardModel> {
        return object : Observer<GiftCardModel> {
            override fun onSubscribe(d: Disposable) {

                disposable=d
                Log.v("subs","done")
            }
            override fun onNext(t: @NonNull GiftCardModel) { // run on main thread
                cardList.postValue(t.giftCardResponseList)

            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {}
        }
    }


}


