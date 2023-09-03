package com.hightech.cryptoapp.crypto.feed.domain

import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity
import kotlinx.coroutines.flow.Flow

interface CryptoFeedCache {
    suspend fun insertAll(vararg cryptoFeedItem: CryptoFeedEntity)
}