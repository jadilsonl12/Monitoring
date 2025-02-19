package com.example.monitoring.service

import android.util.Log
import com.example.monitoring.api.CnpjHelper
import com.example.monitoring.domain.Cnpj

class CnpjService {

    private val cnpjApi = CnpjHelper().cnpjApi

    suspend fun findByCnpj(cnpj: String): Cnpj? {
        try {
            val cnpj = cnpjApi.findByCnpj(cnpj)
            return cnpj
        } catch (e: Exception) {
            Log.e("CnpjService", "findByCnpj: ", e)
            return null
        }
    }
}