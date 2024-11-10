package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.domain.model.Market

interface MarketRepository {
    suspend fun getMarketList() : List<Market>
}