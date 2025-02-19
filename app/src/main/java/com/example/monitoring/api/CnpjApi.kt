package com.example.monitoring.api

import com.example.monitoring.domain.Cnpj
import retrofit2.http.GET
import retrofit2.http.Path

interface CnpjApi {
    @GET("cnpj/v1/{cnpj}")
    suspend fun findByCnpj(@Path("cnpj") cnpj: String) : Cnpj
}