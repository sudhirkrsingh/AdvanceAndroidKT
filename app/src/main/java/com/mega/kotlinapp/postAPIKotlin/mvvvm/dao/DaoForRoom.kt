package com.mega.kotlinapp.postAPIKotlin.mvvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.CardsForRoomData
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.UserData

@Dao
interface DaoForRoom {
//    @Query("SELECT * FROM cardsforroomdata")
//    fun getAll(): List<CardsForRoomData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // or OnConflictStrategy.IGNORE
    fun insertCards(vararg cardsForRoomData: CardsForRoomData)





//@Query("SELECT * FROM user_data")
//fun getAllUser(): LiveData<UserData>
//@Delete
//fun deleteCards()

}