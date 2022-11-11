package com.davidson.breakingbad.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL_RANDOM_USER_API = "https://www.breakingbadapi.com/"
const val NUMBER_OF_CHARACTERS_TO_FETCH = 50


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitBreakingBad = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL_RANDOM_USER_API)
    .build()


interface BreakingBadNetworkService {
    @GET("api/characters")
    suspend fun getAllCharactersFromNetwork(
        @Query("limit")
        numberOfCharactersToFetch: Int = NUMBER_OF_CHARACTERS_TO_FETCH
    ): List<TestNetwork>
}

object BBNetwork {
    val retrofitBreakingBadService: BreakingBadNetworkService by lazy {
        retrofitBreakingBad.create(
            BreakingBadNetworkService::class.java
        )
    }
}