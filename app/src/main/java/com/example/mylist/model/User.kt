package com.example.mylist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true)
                val id: Long,val name: String, val age: String, val email: String)