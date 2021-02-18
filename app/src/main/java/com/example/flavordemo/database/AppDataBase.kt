package com.example.flavordemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flavordemo.database.dao.PersonDao
import com.example.flavordemo.database.entity.Person

@Database(
    entities = [
        Person::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        private var appDatabase: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "flavor-demo"
                )
                    .build()
            }
            return appDatabase!!
        }
    }

    abstract fun personDao(): PersonDao
}