package com.composecoin.feature.marketlist

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.composecoin.domain.market.model.Market
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object MarketListRoot

@Serializable
data object MarketList

@Serializable
data class MarketDetails(
    val market: Market
)

fun NavGraphBuilder.marketListScreen(navController: NavController) {
    navigation<MarketListRoot>(startDestination = MarketList){
        composable<MarketList> {
            val viewModel: MarketListViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            MarketListScreen(marketListState = state, onItemClicked = {
                navController.navigate(MarketDetails(it))
            })
        }
    }

    composable<MarketDetails> (
        typeMap = mapOf(
            typeOf<Market>() to MarketNavType.marketItemType
        )
    ){
        val route = it.toRoute<MarketDetails>()
        MarketDetailsScreen(marketItem = route.market)
    }
}

fun NavController.navigateToMarketListScreen(navOption: NavOptions) {
    navigate(MarketList, navOption)
}

