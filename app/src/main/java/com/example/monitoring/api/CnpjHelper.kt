package com.example.monitoring.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CnpjHelper {
    private val retrofit = Retrofit.Builder().baseUrl("https://brasilapi.com.br/api/")
        .addConverterFactory(MoshiConverterFactory.create()).build()

    val cnpjApi = retrofit.create(CnpjApi::class.java)
}