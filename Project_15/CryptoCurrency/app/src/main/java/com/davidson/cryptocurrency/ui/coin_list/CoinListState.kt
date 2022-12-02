package com.davidson.cryptocurrency.ui.coin_list

import com.davidson.cryptocurrency.data.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
