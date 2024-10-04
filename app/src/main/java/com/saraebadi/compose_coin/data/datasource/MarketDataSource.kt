package com.saraebadi.compose_coin.data.datasource

import com.saraebadi.compose_coin.domain.model.MarketResponse

interface MarketDataSource {
    suspend fun getMarketList(perPage: Int, page: Int) : List<MarketResponse>
}