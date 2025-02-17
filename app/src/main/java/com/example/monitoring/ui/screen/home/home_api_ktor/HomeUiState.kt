package com.example.monitoring.ui.screen.home.home_api_ktor

import com.example.monitoring.data.model.Category
import com.example.monitoring.data.model.Market
import com.google.android.gms.maps.model.LatLng

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)
