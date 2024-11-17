package com.composecoin.feature.marketlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composecoin.domain.market.model.Market

@Composable
fun MarketListScreen(
    modifier: Modifier = Modifier,
    marketListState: UiState<List<Market>>,
    onItemClicked: (Market) -> Unit = {}
){

}