package com.saraebadi.compose_coin.domain.model

sealed class Result<out T> {
    data class Success<T>(val data: T): Result<T>()
    data class Error(val exception: String): Result<Nothing>()
}