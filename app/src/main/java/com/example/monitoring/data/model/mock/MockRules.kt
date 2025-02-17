package com.example.monitoring.data.model.mock

import com.example.monitoring.data.model.Rule

val mockRules = listOf(
    Rule(
        id = "424242424",
        description = "Disponível até 31/12/2024",
        marketId = "2135533"
    ),
    Rule(
        id = "5335353",
        description = "Válido apenas para consumo local",
        marketId = "2135535533"
    )
)