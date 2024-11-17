package com.composecoin.domain.market.usecase

import com.composecoin.domain.market.model.Market
import com.composecoin.domain.market.repository.MarketRepository
import javax.inject.Inject

class GetMarketListUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {
    suspend operator fun invoke(): List<Market> {
        return marketRepository.getMarketList()
    }
}