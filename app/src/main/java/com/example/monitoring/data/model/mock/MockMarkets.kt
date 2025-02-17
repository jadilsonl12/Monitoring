package com.example.monitoring.data.model.mock

import com.example.monitoring.data.model.Market
import com.example.monitoring.data.model.Rule

val mockMarkets = listOf(
    Market(
        id = "12",
        categoryId = "101",
        name = "Supermercado Central",
        description = "O melhor supermercado da região.",
        coupons = 10,
//        rules = listOf(
//            Rule(id = "1", description = "Valido até 12/24", marketId = "12"),
//            Rule(id = "2", description = "Disponível apenas para consumo local", marketId = "12")
//        ),
        latitude = -23.550520,
        longitude = -46.633308,
        address = "Av. Paulista, 1234 - São Paulo, SP",
        phone = "(11) 98765-4321",
        cover = "https://example.com/images/market1.jpg"
    ),
    Market(
        id = "2",
        categoryId = "102",
        name = "Mercadinho da Esquina",
        description = "Uma experiência única de compras.",
        coupons = 15,
//        rules = emptyList(),
        latitude = -22.906847,
        longitude = -43.172896,
        address = "Rua das Flores, 567 - Rio de Janeiro, RJ",
        phone = "(21) 91234-5678",
        cover = "https://example.com/images/market2.jpg"
    )
)