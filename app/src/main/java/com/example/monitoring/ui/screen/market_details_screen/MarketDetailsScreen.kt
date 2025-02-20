package com.example.monitoring.ui.screen.market_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.monitoring.R
import com.example.monitoring.data.model.Market
import com.example.monitoring.database.sampleDataEstablishments
import com.example.monitoring.ui.components.button.NearbyButton
import com.example.monitoring.ui.components.market_details.NearbyMarketDetailsCoupons
import com.example.monitoring.ui.components.market_details.NearbyMarketDetailsInfos
import com.example.monitoring.ui.theme.Typography

val p = sampleDataEstablishments[0]

@Composable
fun MarketDetailsScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onNavigateToRegisterNewReview: () -> Unit,
    onNavigateToReviews: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            contentDescription = "Imagem do Local",
            contentScale = ContentScale.Crop,
            model = p.urlImage
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(36.dp)
            ) {
                Column {
                    Text(text = p.name, style = Typography.headlineLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = p.description, style = Typography.bodyLarge)
                }
                Spacer(modifier = Modifier.height(48.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    NearbyMarketDetailsInfos(
                        market = Market(
                            id = "2",
                            categoryId = "102",
                            name = "Mercadinho da Esquina",
                            description = "Uma experiência única de compras.",
                            coupons = 15,
                            latitude = -22.906847,
                            longitude = -43.172896,
                            address = "Rua das Flores, 567 - Rio de Janeiro, RJ",
                            phone = "(21) 91234-5678",
                            cover = "https://example.com/images/market2.jpg"
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )
                    NearbyMarketDetailsCoupons(coupons = listOf("ABC12345"))
                }

                NearbyButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    text = "Avaliar estabelecimento",
                    onClick = onNavigateToRegisterNewReview
                )

                NearbyButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    text = "Listar avaliações",
                    onClick = onNavigateToReviews
                )
            }
        }

        NearbyButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(24.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigateBack
        )
    }
}

@Preview
@Composable
private fun MarketDetailsScreenPreview() {
    MarketDetailsScreen(
        onNavigateBack = {},
        onNavigateToRegisterNewReview = {},
        onNavigateToReviews = {})
}