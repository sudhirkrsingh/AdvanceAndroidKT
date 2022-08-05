package com.mega.kotlinapp.postAPIKotlin.postapimvp.view.activity

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.mega.kotlinapp.R
import com.mega.kotlinapp.databinding.ActivityMainBinding
import com.mega.kotlinapp.postAPIKotlin.mvvmwithcleanarchitecture.presentation.view.fragment.CleanArchFragment
import com.mega.kotlinapp.postAPIKotlin.mvvvm.view.RxAndroidFragment
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view.FakerApplication
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view.StoreFragment
import com.mega.kotlinapp.postAPIKotlin.postapimvp.presenter.Communicator
import com.mega.kotlinapp.postAPIKotlin.postapimvp.view.fragment.HomeFragment
import com.mega.kotlinapp.postAPIKotlin.postapimvp.view.fragment.SecondFragment


class MainActivity : AppCompatActivity(), Communicator {

    lateinit var check:String
    lateinit var binding: ActivityMainBinding
    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as
                FakerApplication).applicationComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        check="sudhir"
        val rxAndroidFragment = RxAndroidFragment()
        val homeFragment = HomeFragment()
          supportFragmentManager.beginTransaction()
            .replace(R.id.layout_1,CleanArchFragment())
            .commit()

    }

    override fun PassData(text: String) {

        val secondFragment= SecondFragment()
        val bundle = Bundle()
        bundle.putString("check",text!!)
        bundle.putString("sudhir",check)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.layout_1,secondFragment)
            .addToBackStack("fragment")
            .commit()

        secondFragment.arguments = bundle

    }
}