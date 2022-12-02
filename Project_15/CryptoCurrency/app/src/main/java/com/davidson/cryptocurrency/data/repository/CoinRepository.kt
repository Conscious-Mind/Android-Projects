package com.davidson.cryptocurrency.data.repository

import com.davidson.cryptocurrency.common.Resource
import com.davidson.cryptocurrency.data.model.Coin
import com.davidson.cryptocurrency.data.model.CoinDetail
import com.davidson.cryptocurrency.data.remote.dto.CoinDetailDto
import com.davidson.cryptocurrency.data.remote.dto.CoinDto
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}