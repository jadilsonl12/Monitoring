package com.example.monitoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monitoring.ui.routes.DetailsEstablishment
import com.example.monitoring.ui.routes.DetailsReview
import com.example.monitoring.ui.screen.home.HomeScreen
import com.example.monitoring.ui.screen.market_details_screen.MarketDetailsScreen
import com.example.monitoring.ui.screen.splash.SplashScreen
import com.example.monitoring.ui.screen.welcome.WelcomeScreen
import com.example.monitoring.ui.routes.Home
import com.example.monitoring.ui.routes.RegisterNewEstablishment
import com.example.monitoring.ui.routes.RegisterNewReview
import com.example.monitoring.ui.routes.Splash
import com.example.monitoring.ui.routes.Welcome
import com.example.monitoring.ui.screen.home.home_api_ktor.HomeViewModal
import com.example.monitoring.ui.screen.market_details.market_details_api_ktor.MarketDetailsViewModal
import com.example.monitoring.ui.screen.register.RegisterNewEstablishmentScreen
import com.example.monitoring.ui.screen.register.RegisterNewReviewScreen
import com.example.monitoring.ui.screen.review_details.ReviewDetailsScreen
import com.example.monitoring.ui.theme.MonitoringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonitoringTheme {
                val navController = rememberNavController()

                val homeViewModal by viewModels<HomeViewModal>()
                val homeUiState by homeViewModal.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModal by viewModels<MarketDetailsViewModal>()
                val marketDetailsUiState by marketDetailsViewModal.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<RegisterNewEstablishment> {
                        RegisterNewEstablishmentScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable<RegisterNewReview> {
                        RegisterNewReviewScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToRegisterNewEstablishments = {
                                navController.navigate(RegisterNewEstablishment)
                            },
                            onNavigateToDetails = {
                                navController.navigate(DetailsEstablishment)
                            }
                        )
                    }
                    composable<DetailsEstablishment> {
                        MarketDetailsScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onNavigateToRegisterNewReview = {
                                navController.navigate(RegisterNewReview)
                            },
                            onNavigateToReviews = {
                                navController.navigate(DetailsReview)
                            }
                        )
                    }
                    composable<DetailsReview> {
                        ReviewDetailsScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
//                    composable<Market> {
//                        val selectedMarket = it.toRoute<Market>()
//
//                        MarketDetailsScreen(
//                            market = selectedMarket,
//                            onNavigateBack = {
//                                navController.popBackStack()
//                            }
//                        )
//                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MonitoringTheme {

    }
}