package com.saraebadi.compose_coin.presentation.marketlist

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.saraebadi.compose_coin.domain.model.MarketResponse
import com.saraebadi.compose_coin.presentation.marketdetails.MarketDetailsScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object MarketListRoot

@Serializable
data object MarketList

@Serializable
data class MarketDetails(
    val marketResponse: MarketResponse
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
            typeOf<MarketResponse>() to MarketNavType.marketItemType
        )
    ){
        val route = it.toRoute<MarketDetails>()
        MarketDetailsScreen(marketItem = route.marketResponse)
    }
}

fun NavController.navigateToMarketListScreen(navOption: NavOptions) {
    navigate(MarketList, navOption)
}

