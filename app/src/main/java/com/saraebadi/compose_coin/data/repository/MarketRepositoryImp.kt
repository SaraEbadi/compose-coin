package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.data.datasource.MarketDataSource
import com.saraebadi.compose_coin.data.mapper.toMarket
import com.saraebadi.compose_coin.domain.model.Market
import javax.inject.Inject

class MarketRepositoryImp @Inject constructor(
    private val remoteDataSource: MarketDataSource
) : MarketRepository {
    override suspend fun getMarketList(): List<Market> {
        return remoteDataSource.getMarketList(20, 1).map {
            it.toMarket()
        }
    }
}