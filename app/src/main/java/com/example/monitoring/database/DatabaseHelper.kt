package com.example.monitoring.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.monitoring.domain.Establishments

@Database(
    version = 1,
    entities = [Establishments::class]
)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun establishmentsDao(): EstablishmentsDao

    // Static do Kotlin
    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "establishmentsDao.db"
            ).allowMainThreadQueries()
                .build()
        }
    }


}