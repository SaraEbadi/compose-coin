package com.saraebadi.compose_coin.data.service

import com.saraebadi.compose_coin.domain.model.MarketResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {
    @GET("coins/markets")
    suspend fun getMarkets(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<MarketResponse>
}