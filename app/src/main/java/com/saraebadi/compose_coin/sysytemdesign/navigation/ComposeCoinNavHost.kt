package com.saraebadi.compose_coin.sysytemdesign.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.saraebadi.compose_coin.presentation.marketlist.MarketListRoot
import com.saraebadi.compose_coin.presentation.marketlist.marketListScreen

@Composable
fun ComposeCoinNavHost(navController : NavHostController, padding: PaddingValues) {
    NavHost(navController = navController, startDestination = MarketListRoot, modifier = Modifier.padding(padding) ){
        marketListScreen(navController)
    }
}
