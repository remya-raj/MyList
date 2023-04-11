package com.example.mylist.model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@androidx.room.Database(entities = [User::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun userDao() : UserDao
}


object DatabaseBuilder {
    private var INSTANCE: Database? = null
    fun getInstance(context: Context): Database {
        if (INSTANCE == null) {
            synchronized(Database::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }
    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            "user"
        ).build()
}