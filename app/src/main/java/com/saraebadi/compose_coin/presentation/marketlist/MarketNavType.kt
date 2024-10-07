package com.saraebadi.compose_coin.presentation.marketlist

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.saraebadi.compose_coin.domain.model.MarketResponse
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object MarketNavType {
    val marketItemType = object : NavType<MarketResponse>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): MarketResponse? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): MarketResponse {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: MarketResponse): String {
            return Uri.encode(Json.encodeToString(value))
        }
        override fun put(bundle: Bundle, key: String, value: MarketResponse) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}