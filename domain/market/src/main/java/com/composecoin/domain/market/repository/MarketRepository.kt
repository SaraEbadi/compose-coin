package com.composecoin.domain.market.repository

import com.composecoin.domain.market.model.Market

interface MarketRepository {
    suspend fun getMarketList() : List<Market>
}