package com.example.mylist.model

import androidx.lifecycle.MutableLiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("Select * from user")
    fun gelAllUsers(): MutableLiveData<List<User>>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

}