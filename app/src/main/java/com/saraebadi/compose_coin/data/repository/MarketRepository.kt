package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.domain.model.Market
import com.saraebadi.compose_coin.domain.model.Result

interface MarketRepository {
    suspend fun getMarketList() : Result<List<Market>>
}