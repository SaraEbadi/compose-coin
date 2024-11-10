package com.saraebadi.compose_coin.domain.usecase

import com.saraebadi.compose_coin.data.repository.MarketRepository
import com.saraebadi.compose_coin.domain.model.Market
import javax.inject.Inject

class GetMarketListUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): List<Market> {
        return marketRepository.getMarketList()
    }
}