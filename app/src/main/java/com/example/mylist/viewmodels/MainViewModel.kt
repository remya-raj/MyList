package com.example.mylist.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mylist.model.Database
import com.example.mylist.model.DatabaseBuilder
import com.example.mylist.model.User
import com.example.mylist.model.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    lateinit var database: Database
    var list: MutableLiveData<List<User>> = MutableLiveData<List<User>>()

    fun initDb(context: Context) {
        database = DatabaseBuilder.getInstance(context)
    }

    fun getUserList() {
        list = database.userDao().gelAllUsers()
    }

    fun addUser(user: User) {
        database.userDao().insertUser(user)
    }

}
