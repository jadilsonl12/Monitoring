package com.example.monitoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monitoring.ui.routes.Details
import com.example.monitoring.ui.screen.home.HomeScreen
import com.example.monitoring.ui.screen.market_details_screen.MarketDetailsScreen
import com.example.monitoring.ui.screen.splash.SplashScreen
import com.example.monitoring.ui.screen.welcome.WelcomeScreen
import com.example.monitoring.ui.routes.Home
import com.example.monitoring.ui.routes.Register
import com.example.monitoring.ui.routes.Splash
import com.example.monitoring.ui.routes.Welcome
import com.example.monitoring.ui.screen.register.RegisterScreen
import com.example.monitoring.ui.theme.MonitoringTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonitoringTheme {
                val navController = rememberNavController()
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
                    composable<Register> {
                        RegisterScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToRegister = {
                                navController.navigate(Register)
                            },
                            onNavigateToDetails = {
                                navController.navigate(Details)
                            }
                        )
                    }
                    composable<Details> {
                        MarketDetailsScreen(
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