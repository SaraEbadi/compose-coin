package com.saraebadi.compose_coin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.saraebadi.compose_coin.presentation.marketlist.navigateToMarketListScreen
import com.saraebadi.compose_coin.presentation.ui.theme.ComposecoinTheme
import com.saraebadi.compose_coin.sysytemdesign.navigation.ComposeCoinNavHost
import com.saraebadi.compose_coin.sysytemdesign.navigation.TopLevelDestination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposecoinTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) { innerPadding ->
                    ComposeCoinNavHost(navController = navController, padding = innerPadding)
                }
            }
        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val route = backStackEntry?.destination?.route ?: ""
    selectedTab = when {
        route.contains("Coins Rate", ignoreCase = true) -> 0
        route.contains("Settings", ignoreCase = true) -> 0
        else -> -1
    }
    NavigationBar {
        TopLevelDestination.entries.forEachIndexed { index, topLevelDestination ->
            val selected = selectedTab == index
            NavigationBarItem(selected = selected,
                onClick = { navigateToBottomNavDestination(navHostController, topLevelDestination) },
                icon = { Icon(imageVector = if (selected) topLevelDestination.selectedIcon else topLevelDestination.unselectedIcon, contentDescription = "Navigation Icon") })
        }
    }
}

private fun navigateToBottomNavDestination(navHostController: NavHostController, topLevelDestination: TopLevelDestination) {
    val topLevelNavOptions = navOptions {
        popUpTo(navHostController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
    when(topLevelDestination) {
        TopLevelDestination.COINS_RATE -> navHostController.navigateToMarketListScreen(topLevelNavOptions)
        TopLevelDestination.SETTINGS -> {}
        else -> {}
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposecoinTheme {
        Greeting("Android")
    }
}