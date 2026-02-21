package com.saraebadi.compose_coin.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Market(
    val id: String,
    val name: String,
    val symbol: String = "",
    val imageUrl: String = "",
    val currentPrice: Double? = 1.1,
    val totalVolume: Double = 1.2,
    val totalSupply: Double = 1.2,
    val marketCap: Double = 1.2,
    val priceChangePercentage24h: Double = 1.2,
    val lastUpdated: String = "",
)