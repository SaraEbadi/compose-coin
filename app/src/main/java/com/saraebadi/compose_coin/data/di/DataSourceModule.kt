package com.saraebadi.compose_coin.data.di

import com.saraebadi.compose_coin.data.datasource.MarketDataSource
import com.saraebadi.compose_coin.data.datasource.MarketDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindMarketDataSource(
        marketDataSource: MarketDataSourceImp
    ): MarketDataSource
}