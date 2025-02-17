package com.example.monitoring.ui.screen.review_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monitoring.R
import com.example.monitoring.database.DatabaseHelper
import com.example.monitoring.domain.Reviews
import com.example.monitoring.ui.theme.Typography
import com.example.monitoring.ui.components.button.NearbyButton
import com.example.monitoring.ui.components.review.NearbyReviewCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ReviewDetailsScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    var reviews = remember { mutableStateListOf<Reviews>() }
    LaunchedEffect(true) {
        Thread.sleep(3000L)
        val data = withContext(Dispatchers.IO) {
            DatabaseHelper
                .getInstance(context)
                .reviewsDao()
                .findAll()
        }

        reviews.addAll(data)
    }

    Column(
        modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        NearbyButton(
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigateBack
        )
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(text = "Avaliações de clientes", style = Typography.bodyLarge)
            }

            items(reviews) { review ->
                NearbyReviewCard(
                    modifier = Modifier.fillMaxWidth(),
                    r = review,
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_3
)
@Composable
private fun ReviewDetailsScreenPreview() {
    ReviewDetailsScreen(modifier = Modifier, onNavigateBack = {})
}