package com.example.monitoring.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.monitoring.domain.Establishments

@Dao
interface EstablishmentsDao {

    @Insert
    fun insert(establishments: Establishments)

    @Query("SELECT * FROM Establishments")
    fun findAll(): List<Establishments>

    @Query("SELECT * FROM Establishments WHERE id = :id")
    fun findById(id: Long): Establishments?
}