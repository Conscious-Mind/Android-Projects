package com.davidson.cryptocurrency.ui.coin_detail

import com.davidson.cryptocurrency.data.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
