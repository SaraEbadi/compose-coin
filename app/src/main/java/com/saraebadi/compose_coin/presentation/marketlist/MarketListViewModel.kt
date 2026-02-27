package com.saraebadi.compose_coin.presentation.marketlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraebadi.compose_coin.domain.model.Market
import com.saraebadi.compose_coin.domain.model.Result
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
            when(val result = marketListUseCase()) {
                is Result.Success -> _state.update { it.copy(isLoading = false, markets = result.data) }
                is Result.Error -> _state.update { it.copy(isLoading = false, error = result.exception) }
            }
        }
    }
}