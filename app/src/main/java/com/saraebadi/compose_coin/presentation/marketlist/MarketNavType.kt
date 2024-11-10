package com.saraebadi.compose_coin.presentation.marketlist

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.saraebadi.compose_coin.domain.model.Market
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object MarketNavType {
    val marketItemType = object : NavType<Market>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Market? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Market {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Market): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Market) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}