package com.saraebadi.compose_coin.data.datasource

import com.saraebadi.compose_coin.data.service.MarketApi
import com.saraebadi.compose_coin.data.dto.MarketResponse
import javax.inject.Inject

class MarketDataSourceImp@Inject constructor(
    private val api: MarketApi
) : MarketDataSource {
    override suspend fun getMarketList(currency: String, perPage: Int, page: Int): List<MarketResponse> {
        return api.getMarkets(currency, perPage, page)
    }
}