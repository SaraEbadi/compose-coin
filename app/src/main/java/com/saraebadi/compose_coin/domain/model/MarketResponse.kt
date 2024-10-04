package com.saraebadi.compose_coin.domain.model

import kotlinx.serialization.SerialName

data class MarketResponse(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("image") val image: String,
    @SerialName("current_price") val currentPrice: Double,
    @SerialName("total_volume") val totalVolume: Double,
    @SerialName("total_supply") val totalSupply: Double,
    @SerialName("market_cap") val marketCap: Double,
    @SerialName("price_change_percentage_24h") val priceChangePercentage24h: Double,
    @SerialName("last_updated") val lastUpdated: String,
)