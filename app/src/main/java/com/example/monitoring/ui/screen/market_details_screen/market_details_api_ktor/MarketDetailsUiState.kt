package com.example.monitoring.ui.screen.market_details.market_details_api_ktor

import com.example.monitoring.data.model.Rule

data class MarketDetailsUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null
)