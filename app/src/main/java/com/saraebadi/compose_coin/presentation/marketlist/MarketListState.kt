package com.saraebadi.compose_coin.presentation.marketlist

import com.saraebadi.compose_coin.domain.model.Market

data class MarketListState(
    val markets: List<Market> = listOf(),
    val isLoading: Boolean = false,
    val error: String = ""
)