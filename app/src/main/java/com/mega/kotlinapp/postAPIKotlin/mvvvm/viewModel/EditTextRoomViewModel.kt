package com.mega.kotlinapp.postAPIKotlin.mvvvm.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mega.kotlinapp.postAPIKotlin.mvvvm.Database.UserDatabase
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.UserData
 class EditTextRoomViewModel:ViewModel() {

    private var context: Context?=null

     var userName= MutableLiveData<String>()
      var userSurName=MutableLiveData<String>()
      var userPhoneNo=MutableLiveData<String>()
    lateinit var database: UserDatabase

    fun setContext(context: Context){
        this.context=context
    }

    fun saveData(){

        var userData = UserData(0, userName.value!!,userSurName.value!!,userPhoneNo.value!!)

        database= context?.let { UserDatabase.getDatabase(it) }!!


        database!!.daoForUser().insertUser(userData)
        Toast.makeText(context, "check your db data has been saved...", Toast.LENGTH_SHORT).show()

    }
}