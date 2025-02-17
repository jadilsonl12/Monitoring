package com.example.monitoring.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Reviews(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val comment: String,
    val assessment: Int,
    val urlImage: String
)