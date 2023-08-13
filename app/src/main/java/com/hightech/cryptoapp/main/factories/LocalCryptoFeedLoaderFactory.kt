package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.db.usecases.LocalCryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader

class LocalCryptoFeedLoaderFactory {
    companion object {
        fun createLocalCryptoFeedLoader(): CryptoFeedLoader {
            return LocalCryptoFeedLoader(
                CryptoFeedDaoFactory.createCryptoFeedDao()
            )
        }
    }
}