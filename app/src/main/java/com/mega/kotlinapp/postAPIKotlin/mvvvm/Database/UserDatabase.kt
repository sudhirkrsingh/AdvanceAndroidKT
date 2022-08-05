package com.mega.kotlinapp.postAPIKotlin.mvvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mega.kotlinapp.postAPIKotlin.mvvvm.dao.DaoForRoom
import com.mega.kotlinapp.postAPIKotlin.mvvvm.dao.DaoForUser
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.CardsForRoomData
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.UserData

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun daoForUser(): DaoForUser

    companion object {
        @Volatile // it will help to all thread to get acknowledgment of that its instance being created.
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext,UserDatabase::class.java, "user_database")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}