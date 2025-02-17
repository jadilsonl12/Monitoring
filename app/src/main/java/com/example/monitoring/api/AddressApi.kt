package com.example.monitoring.api

import com.example.monitoring.domain.Address
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressApi {
    @GET("cep/v1/{cep}")
    suspend fun findByCep(@Path("cep") cep: String): Address
}