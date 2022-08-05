package com.mega.kotlinapp.postAPIKotlin.mvvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.UserData

@Dao
interface DaoForUser {

    @Insert
    fun insertUser(vararg userData: UserData)
}