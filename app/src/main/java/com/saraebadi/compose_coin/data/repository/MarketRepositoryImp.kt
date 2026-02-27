package com.saraebadi.compose_coin.data.repository

import com.saraebadi.compose_coin.data.datasource.MarketDataSource
import com.saraebadi.compose_coin.data.mapper.toMarket
import com.saraebadi.compose_coin.domain.model.Market
import com.saraebadi.compose_coin.domain.model.Result
import javax.inject.Inject

class MarketRepositoryImp @Inject constructor(
    private val remoteDataSource: MarketDataSource
) : MarketRepository {
    override suspend fun getMarketList(): Result<List<Market>> {
        return try {
            val response = remoteDataSource.getMarketList("usd",20, 1)
                .map {
                    it.toMarket()
                }
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Something went wrong")
        }
    }
}