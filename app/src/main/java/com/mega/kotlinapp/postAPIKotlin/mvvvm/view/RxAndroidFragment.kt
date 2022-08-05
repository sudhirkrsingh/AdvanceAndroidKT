package com.mega.kotlinapp.postAPIKotlin.mvvvm.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mega.kotlinapp.databinding.FragmentRxAndroidBinding
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.ObservableModel
import com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel.GeneratingData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Predicate
import io.reactivex.rxjava3.schedulers.Schedulers


class RxAndroidFragment : Fragment() {

    val TAG:String = "MainActivity"
    var disposable:CompositeDisposable = CompositeDisposable()

   lateinit var binding: FragmentRxAndroidBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRxAndroidBinding.inflate(inflater, container, false)


        var observable: @NonNull Observable<ObservableModel> = Observable.
        fromIterable(GeneratingData.createTasksList())
            .subscribeOn(Schedulers.newThread())
            .filter(object : Predicate<ObservableModel> {
                override fun test(t: ObservableModel): Boolean {
                    Thread.sleep(1000)
                    Log.v(TAG, "new thread: " + Thread.currentThread().name)

                    return t.isComplete
                }

            })
            .observeOn(AndroidSchedulers.mainThread())

        observable.subscribe(object : Observer<ObservableModel> {
            override fun onSubscribe(d: Disposable) {

                disposable.add(d)
                Log.v("subs","done")
            }
            override fun onNext(task: ObservableModel) { // run on main thread
                Log.v(TAG, "onNext: : " + task.description)
                Log.v(TAG, "onNext: : " + Thread.currentThread().name)


                if(task.description.equals("Make dinner")){
                    binding.text.setText("Yeah you got the string")

                }

            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {}
        })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()// Normal clear
    }

}