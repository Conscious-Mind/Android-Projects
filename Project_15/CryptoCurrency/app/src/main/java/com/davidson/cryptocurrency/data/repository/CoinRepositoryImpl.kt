package com.davidson.cryptocurrency.data.repository

import com.davidson.cryptocurrency.common.Resource
import com.davidson.cryptocurrency.data.model.Coin
import com.davidson.cryptocurrency.data.model.CoinDetail
import com.davidson.cryptocurrency.data.remote.CoinPaprikaApi
import com.davidson.cryptocurrency.data.remote.dto.CoinDetailDto
import com.davidson.cryptocurrency.data.remote.dto.CoinDto
import com.davidson.cryptocurrency.data.remote.dto.toCoin
import com.davidson.cryptocurrency.data.remote.dto.toCoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}