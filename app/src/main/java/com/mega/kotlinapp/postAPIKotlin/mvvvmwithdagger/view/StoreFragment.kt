package com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mega.kotlinapp.databinding.FragmentStoreBinding
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.di.ApplicationComponent

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.repo.Repository

import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.model.PostBodyModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.network.PostAPI
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.viewmodel.StoreViewModel
import com.mega.kotlinapp.postAPIKotlin.mvvvmwithdagger.viewmodel.StoreViewModelFactory
import javax.inject.Inject


class StoreFragment : Fragment() {

    lateinit var binding:FragmentStoreBinding
    lateinit var viewModel: StoreViewModel


    private var mActivity:Context?=null


    @Inject
    lateinit var postBodyModel: PostBodyModel
    @Inject
    lateinit var storeViewModelFactory: StoreViewModelFactory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity= context as Activity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentStoreBinding.inflate(inflater, container, false)


        ((mActivity as Activity).application as FakerApplication).applicationComponent.inject(this)

        postBodyModel.stores="All"

        viewModel = ViewModelProvider(this, storeViewModelFactory).get(
                StoreViewModel::class.java
            )
        viewModel.getAllStores()

        viewModel.storeList.observe(viewLifecycleOwner){ it->



            if (it !=null){
                binding.recview.adapter= context?.let { it1 -> StoreAdapter(it1,it) }
                Log.v("Thread","thread: "+Thread.currentThread())
                Toast.makeText(context, "Congratulations selection hogyi aapki ", Toast.LENGTH_SHORT).show()

            }
            else{

                Toast.makeText(context, "Bhai kya kr rha h tu  \n \n \n Ashneer grover", Toast.LENGTH_SHORT).show()
            }
        }



        return binding.root
    }


}