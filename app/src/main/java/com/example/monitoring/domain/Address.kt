package com.example.monitoring.domain

data class Address(
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
)