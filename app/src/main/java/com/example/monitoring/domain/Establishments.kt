package com.example.monitoring.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Establishments(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val categoryId: String,
    val name: String,
    val description: String,
    val coupons: Int,
    val address: String,
    val phone: String,
    val urlImage: String
)