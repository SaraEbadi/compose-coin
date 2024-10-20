package com.saraebadi.compose_coin.data.mapper

import com.saraebadi.compose_coin.data.dto.MarketResponse
import com.saraebadi.compose_coin.domain.model.Market


fun MarketResponse.toMarket() : Market = Market(
    id = id,
    name = name,
    symbol = symbol,
    imageUrl = imageUrl,
    currentPrice = currentPrice,
    totalVolume = totalVolume,
    totalSupply = totalSupply,
    marketCap = marketCap,
    priceChangePercentage24h = priceChangePercentage24h,
    lastUpdated = lastUpdated
)