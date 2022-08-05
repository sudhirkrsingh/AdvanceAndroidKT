package com.mega.kotlinapp.postAPIKotlin.mvvvm.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mega.kotlinapp.databinding.FragmentGetCardsBinding
import com.mega.kotlinapp.postAPIKotlin.mvvvm.Database.AppDatabase
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.CardsForRoomData
import com.mega.kotlinapp.postAPIKotlin.mvvvm.network.GetAPI
import com.mega.kotlinapp.postAPIKotlin.mvvvm.network.GetCards
import com.mega.kotlinapp.postAPIKotlin.mvvvm.repo.Repository

import com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel.GiftCardViewModel
import com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel.ViewModelFactory


class GetCardsFragment : Fragment() {


    lateinit var binding:FragmentGetCardsBinding
    lateinit var viewModel: GiftCardViewModel
    private val retrofitService:GetCards = GetAPI.getCards()!!.create(GetCards::class.java)
    private val service:GetCards = GetCards.getCards()!!.create(GetCards::class.java)
    lateinit var database: AppDatabase

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentGetCardsBinding.inflate(inflater, container, false)

        binding.recview.layoutManager=LinearLayoutManager(context)


        database= context?.let { AppDatabase.getDatabase(it) }!!


        viewModel =
            ViewModelProvider(this,ViewModelFactory(Repository(service))).get(
                GiftCardViewModel::class.java
            )
        viewModel.getAllCards()

        viewModel.cardList.observe(this) { it ->
            if (it != null) {
//
                var size:Int
                size = it.size
                Toast.makeText(context, "checking: "+size, Toast.LENGTH_SHORT).show()


                for (i in 0..size-1){
                    var cardsForRoomData = CardsForRoomData(1,marketingContent01 = it[i].marketingContent01,marketingContent02 = it[i].marketingContent02,giftCardName = it[i].giftCardName)
                    database!!.daoForRom().insertCards(cardsForRoomData)
                }
//                it[0].marketingContent01
//                it[1].marketingContent02
                binding.recview.adapter = context?.let { it1 -> CardAdapter(it1, it) }
//                Toast.makeText(context, "data" + it[0], Toast.LENGTH_SHORT).show()
                Toast.makeText(context, ""+Thread.currentThread(), Toast.LENGTH_SHORT).show()
                Log.v("jh","thread"+Thread.currentThread())



            }
            else {

            }

        }

//        viewModel.movieList.observe(this, io.reactivex.rxjava3.core.Observer { it ->
//            //TODO
//        })
//        viewModel.movieList.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                adapter.list=
//            } else {
//                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
//            }
//        })





        return binding.root
    }

    override fun onDestroy() {
        //don't send events  once the activity is destroyed
        viewModel.disposable.dispose()
        super.onDestroy()
    }
}