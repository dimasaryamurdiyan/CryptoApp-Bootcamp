package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.db.usecases.InsertCryptoFeedUseCase
import com.hightech.cryptoapp.crypto.feed.db.usecases.LocalCryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedCache
import com.singaludra.featurefeed.domain.CryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): com.singaludra.featurefeed.domain.CryptoFeedLoader {
            return LocalCryptoFeedLoader(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }

        fun createInsertCryptoFeed(): com.singaludra.featurefeed.domain.CryptoFeedCache {
            return InsertCryptoFeedUseCase(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }
    }
}