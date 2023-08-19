package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.db.usecases.InsertCryptoFeedUseCase
import com.hightech.cryptoapp.crypto.feed.db.usecases.LocalCryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedCache
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }

        fun createInsertCryptoFeed(): CryptoFeedCache {
            return InsertCryptoFeedUseCase(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }
    }
}