package com.example.monitoring.ui.screen.home.home_api_ktor

sealed class HomeUiEvent {
    data object onFetchCategories : HomeUiEvent()
    data class onFetchMarkets(val categoryId: String) : HomeUiEvent()
}