package com.mega.kotlinapp.postAPIKotlin.mvvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mega.kotlinapp.databinding.FragmentEditTextRoomBinding
import com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel.EditTextRoomViewModel


class EditTextRoomFragment : Fragment() {

    lateinit var binding: FragmentEditTextRoomBinding
    lateinit var editTextRoomViewModel:EditTextRoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEditTextRoomBinding.inflate(inflater, container, false)



        editTextRoomViewModel=ViewModelProvider(this).get(EditTextRoomViewModel::class.java)
        binding.editTextViewModel=editTextRoomViewModel


        context?.let { editTextRoomViewModel.setContext(it) }

        binding.lifecycleOwner=this

        return binding.root
    }


}