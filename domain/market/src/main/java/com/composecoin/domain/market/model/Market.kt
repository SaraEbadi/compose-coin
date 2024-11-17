package com.composecoin.domain.market.model

import kotlinx.serialization.Serializable

@Serializable
data class Market(
    val id: String,
    val name: String,
    val symbol: String,
    val imageUrl: String,
    val currentPrice: Double,
    val totalVolume: Double,
    val totalSupply: Double,val marketCap: Double,
    val priceChangePercentage24h: Double,
    val lastUpdated: String,
)
