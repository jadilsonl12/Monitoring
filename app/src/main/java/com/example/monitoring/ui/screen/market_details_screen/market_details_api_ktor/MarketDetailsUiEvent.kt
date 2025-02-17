package com.example.monitoring.ui.screen.market_details.market_details_api_ktor

sealed class MarketDetailsUiEvent {
    data class OnFetchRules(val marketId: String) : MarketDetailsUiEvent()
    data class OnFetchCoupon(val qrCodeContent: String) : MarketDetailsUiEvent()
    data object onResetCoupon : MarketDetailsUiEvent()
}