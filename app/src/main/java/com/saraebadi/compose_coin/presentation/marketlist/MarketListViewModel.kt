package com.saraebadi.compose_coin.presentation.marketlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraebadi.compose_coin.domain.model.Market
import com.saraebadi.compose_coin.domain.usecase.GetMarketListUseCase
import com.saraebadi.compose_coin.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketListViewModel@Inject constructor(
    private val marketListUseCase: GetMarketListUseCase
): ViewModel() {

    private val _state: MutableStateFlow<MarketListState> = MutableStateFlow(MarketListState())
    val state = _state.asStateFlow()

    init {
        getMarketList()
    }

    fun getMarketList() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val response = marketListUseCase()
                _state.update { it.copy(isLoading = false, markets = response) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message ?: "Something went wrong!") }
            }
        }
    }
}