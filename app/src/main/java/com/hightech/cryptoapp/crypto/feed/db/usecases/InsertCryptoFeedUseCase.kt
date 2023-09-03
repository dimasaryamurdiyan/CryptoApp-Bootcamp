package com.hightech.cryptoapp.crypto.feed.db.usecases

import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity
import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao
import com.singaludra.featurefeed.domain.CryptoFeedCache


class InsertCryptoFeedUseCase constructor(private val cryptoFeedDao: CryptoFeedDao):
    com.singaludra.featurefeed.domain.CryptoFeedCache {
    override suspend fun insertAll(vararg cryptoFeedItem: CryptoFeedEntity) {
        cryptoFeedDao.insertAll(*cryptoFeedItem)
    }
}