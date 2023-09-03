package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.cache.usecases.InsertCryptoFeedUseCase
import com.singaludra.featurefeed.cache.usecases.LocalCryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedCache
import com.singaludra.featurefeed.domain.CryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): com.singaludra.featurefeed.domain.CryptoFeedLoader {
            return com.singaludra.featurefeed.cache.usecases.LocalCryptoFeedLoader(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }

        fun createInsertCryptoFeed(): com.singaludra.featurefeed.domain.CryptoFeedCache {
            return com.singaludra.featurefeed.cache.usecases.InsertCryptoFeedUseCase(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }
    }
}