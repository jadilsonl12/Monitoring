package com.example.monitoring.service

import android.util.Log
import com.example.monitoring.api.RetrofitHelper
import com.example.monitoring.domain.Address

class AddressService {

    private val addressApi = RetrofitHelper().adrressApi

    suspend fun findByCep(cep: String): Address? {
        try {
            val address = addressApi.findByCep(cep)
            return address
        } catch (e: Exception) {
            Log.e("AddressService", "findByCep: ", e)
            return null
        }
    }
}