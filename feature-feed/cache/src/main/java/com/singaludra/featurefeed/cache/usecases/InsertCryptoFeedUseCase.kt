package com.singaludra.featurefeed.cache.usecases

import com.singaludra.featurefeed.domain.CryptoFeedEntity
import com.singaludra.featurefeed.cache.room.CryptoFeedDao


class InsertCryptoFeedUseCase constructor(private val cryptoFeedDao: CryptoFeedDao):
    com.singaludra.featurefeed.domain.CryptoFeedCache {
    override suspend fun insertAll(vararg cryptoFeedItem: CryptoFeedEntity) {
        cryptoFeedDao.insertAll(*cryptoFeedItem)
    }
}