package com.saraebadi.compose_coin.data.service

import com.saraebadi.compose_coin.data.dto.MarketDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {
    @GET("coins/markets")
    suspend fun getMarkets(
        @Query("vs_currency") currency: String,
    ): List<MarketDto>
}

//https://api.coingecko.com/api/v3/coins/markets?x_cg_demo_api_key=CG-uDxXL4APGoLcZDDqdfq5CRNn?vs_currency=usd
//https://pro-api.coingecko.com/api/v3/coins/markets?vs_currency=usd