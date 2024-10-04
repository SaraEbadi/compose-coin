package com.saraebadi.compose_coin.data.di

import com.saraebadi.compose_coin.data.repository.MarketRepository
import com.saraebadi.compose_coin.data.repository.MarketRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMarketRepository(
        marketRepository: MarketRepositoryImp
    ): MarketRepository
}