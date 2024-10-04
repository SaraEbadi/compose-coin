package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.data.datasource.MarketDataSource
import com.saraebadi.compose_coin.domain.model.MarketResponse
import javax.inject.Inject

class MarketRepositoryImp @Inject constructor(
    private val remoteDataSource: MarketDataSource
) : MarketRepository {
    override suspend fun getMarketList(): List<MarketResponse> {
        return remoteDataSource.getMarketList(20, 1)
    }
}