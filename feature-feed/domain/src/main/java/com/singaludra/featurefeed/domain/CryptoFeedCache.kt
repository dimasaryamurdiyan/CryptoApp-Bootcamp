package com.singaludra.featurefeed.domain

import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity

interface CryptoFeedCache {
    suspend fun insertAll(vararg cryptoFeedItem: CryptoFeedEntity)
}