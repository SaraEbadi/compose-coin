package com.saraebadi.compose_coin.domain.model.usecase

import com.saraebadi.compose_coin.data.repository.MarketRepository
import com.saraebadi.compose_coin.domain.model.MarketResponse
import javax.inject.Inject

class GetMarketListUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): List<MarketResponse> {
        return marketRepository.getMarketList()
    }
}