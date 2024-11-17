package com.composecoin.feature.marketlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composecoin.domain.market.model.Market
import com.composecoin.domain.market.usecase.GetMarketListUseCase
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

    private val _state: MutableStateFlow<UiState<List<Market>>> = MutableStateFlow(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        getMarketList()
    }

    fun getMarketList() {
        _state.update { UiState.Loading }
        viewModelScope.launch {
            try {
                _state.update { UiState.Success(marketListUseCase())}
            } catch (e: Exception) {
                _state.update { UiState.Error(e.message)}
            }
        }
    }
}