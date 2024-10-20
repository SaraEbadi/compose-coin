package com.saraebadi.compose_coin.presentation.marketlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.saraebadi.compose_coin.domain.model.Market
import com.saraebadi.compose_coin.util.UiState

@Composable
fun MarketListScreen(
    modifier: Modifier = Modifier,
    marketListState: UiState<List<Market>>,
    onItemClicked: (Market) -> Unit = {}
){

}