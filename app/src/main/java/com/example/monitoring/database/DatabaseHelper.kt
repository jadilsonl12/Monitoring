package com.example.monitoring.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.monitoring.domain.Establishments
import com.example.monitoring.domain.Reviews

@Database(
    version = 2,
    entities = [Establishments::class, Reviews::class]
)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun establishmentsDao(): EstablishmentsDao
    abstract fun reviewsDao(): ReviewsDao

    // Static do Kotlin
    companion object {
        fun getInstance(context: Context): DatabaseHelper {
            return Room.databaseBuilder(
                context,
                DatabaseHelper::class.java,
                "monitoring_database.db",
            ).allowMainThreadQueries().fallbackToDestructiveMigration()
                .build()
        }
    }


}