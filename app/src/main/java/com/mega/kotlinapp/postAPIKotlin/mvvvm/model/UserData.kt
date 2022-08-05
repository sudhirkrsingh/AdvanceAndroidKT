package com.mega.kotlinapp.postAPIKotlin.mvvvm.model

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data")
data class UserData(@PrimaryKey(autoGenerate = true) var id: Int,
                    @ColumnInfo(name = "name") var name: String,
                    @ColumnInfo(name = "surname") var surname: String,
                    @ColumnInfo(name = "phoneNo") var phoneNo: String
)
