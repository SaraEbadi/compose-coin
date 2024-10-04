package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.domain.model.MarketResponse

interface MarketRepository {
    suspend fun getMarketList() : List<MarketResponse>
}