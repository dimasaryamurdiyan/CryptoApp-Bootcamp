package com.singaludra.featurefeed.domain


interface CryptoFeedCache {
    suspend fun insertAll(vararg cryptoFeedItem: CryptoFeedEntity)
}