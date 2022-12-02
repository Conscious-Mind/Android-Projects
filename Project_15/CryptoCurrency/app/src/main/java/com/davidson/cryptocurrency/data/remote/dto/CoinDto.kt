package com.davidson.cryptocurrency.data.remote.dto


import com.davidson.cryptocurrency.data.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val id: String, // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean, // true
    @SerializedName("is_new")
    val isNew: Boolean, // false
    @SerializedName("name")
    val name: String, // Bitcoin
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("symbol")
    val symbol: String, // BTC
    @SerializedName("type")
    val type: String // coin
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}