package com.example.monitoring.ui.components.market


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monitoring.database.DatabaseHelper
import com.example.monitoring.domain.Establishments
import com.example.monitoring.ui.theme.Typography
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun NearbyMarketCardList(
    modifier: Modifier = Modifier,
    onNavigateToRegisterNewEstablishments: () -> Unit,
    onNavigateToDetails: () -> Unit
) {
    val context = LocalContext.current
    var establishments = remember { mutableStateListOf<Establishments>() }

    LaunchedEffect(true) {
        Thread.sleep(3000L)
        val data = withContext(Dispatchers.IO) {
            DatabaseHelper
                .getInstance(context)
                .establishmentsDao()
                .findAll()
        }

        establishments.addAll(data)
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToRegisterNewEstablishments
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(text = "Explore lugares perto de você", style = Typography.bodyLarge)
                }

                items(establishments) { establishment ->
                    NearbyMarketCard(
                        modifier = Modifier.fillMaxWidth(),
                        p = establishment,
                        onNavigateToDetails = {
                            onNavigateToDetails()
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun NearbyMarketCardListPreview() {
    NearbyMarketCardList(onNavigateToRegisterNewEstablishments = {}, onNavigateToDetails = {})
}