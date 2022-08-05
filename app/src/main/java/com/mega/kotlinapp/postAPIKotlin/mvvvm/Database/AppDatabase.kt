package com.mega.kotlinapp.postAPIKotlin.mvvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mega.kotlinapp.postAPIKotlin.mvvvm.dao.DaoForRoom
import com.mega.kotlinapp.postAPIKotlin.mvvvm.model.CardsForRoomData

@Database(entities = [CardsForRoomData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoForRom(): DaoForRoom

    companion object {
        @Volatile // it will help to all thread to get acknowledgment of that its instance being created.
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "contact_database")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}