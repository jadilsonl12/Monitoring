package com.example.monitoring.ui.screen.home.home_api_ktor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monitoring.data.model.Market
import com.example.monitoring.ui.components.category.NearbyCategoryFilterChipList
import com.example.monitoring.ui.components.home.NearbyGoogleMap
import com.example.monitoring.ui.components.market.market_card_api_ktor.NearbyMarketCardListApiKtor
import com.example.monitoring.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenApiKtor(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    onNavigateToMarketDetails: (Market) -> Unit,
    onNavigateToRegisterNewEstablishments: () -> Unit,
    onNavigateToDetails: () -> Unit
) {
    val bottonSheetState = rememberBottomSheetScaffoldState()

    val configuration = LocalConfiguration.current

    LaunchedEffect(key1 = true) {
        onEvent(HomeUiEvent.onFetchCategories)
    }

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = bottonSheetState,
        sheetContainerColor = Gray100,
        sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            if (!uiState.markets.isNullOrEmpty()) {
                NearbyMarketCardListApiKtor(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    markets = uiState.markets,
                    onMarketClick = { selectedMarket ->
                        onNavigateToMarketDetails(selectedMarket)
                    },
                    onNavigateToRegisterNewEstablishments = {
                        onNavigateToRegisterNewEstablishments()
                    },
                    onNavigateToDetails = {
                        onNavigateToDetails()
                    }
                )
            }

        },
        content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = it
                            .calculateBottomPadding()
                            .minus(8.dp)
                    )
            ) {
                NearbyGoogleMap(uiState = uiState)

                if (!uiState.categories.isNullOrEmpty()) {
                    NearbyCategoryFilterChipList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                        categories = uiState.categories,
                        onSelectedCategoryChanged = { selectedCategory ->
                            onEvent(HomeUiEvent.onFetchMarkets(categoryId = selectedCategory.id))
                        }
                    )
                }

            }
        }
    )

}


@Preview
@Composable
private fun HomeScreenApiKtorPreview() {
    HomeScreenApiKtor(
        onNavigateToMarketDetails = {},
        uiState = HomeUiState(),
        onEvent = {},
        onNavigateToRegisterNewEstablishments = {},
        onNavigateToDetails = {})
}