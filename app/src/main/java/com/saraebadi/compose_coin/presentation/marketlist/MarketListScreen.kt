package com.saraebadi.compose_coin.presentation.marketlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.saraebadi.compose_coin.domain.model.MarketResponse
import com.saraebadi.compose_coin.util.UiState

@Composable
fun MarketListScreen(
    modifier: Modifier = Modifier,
    marketListState: UiState<List<MarketResponse>>,
    onItemClicked: (MarketResponse) -> Unit = {}
){

}