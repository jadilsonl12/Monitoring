package com.example.monitoring.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.monitoring.domain.Reviews

@Dao
interface ReviewsDao {
    @Insert
    fun insert(reviews: Reviews)

    @Query("SELECT * FROM Reviews")
    fun findAll(): List<Reviews>
}