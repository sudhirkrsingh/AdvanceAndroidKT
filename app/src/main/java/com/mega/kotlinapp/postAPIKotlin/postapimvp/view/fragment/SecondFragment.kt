package com.mega.kotlinapp.postAPIKotlin.postapimvp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mega.kotlinapp.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentSecondBinding.inflate(inflater, container, false)


       val data: String? =arguments?.getString("check")

        binding.data.text = data
        return binding.root
    }


}