package com.saraebadi.compose_coin.data.datasource

import com.saraebadi.compose_coin.data.dto.MarketDto

interface MarketDataSource {
    suspend fun getMarketList(currency: String, perPage: Int, page: Int) : List<MarketDto>
}