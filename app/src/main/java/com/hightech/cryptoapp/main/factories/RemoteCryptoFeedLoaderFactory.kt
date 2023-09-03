package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.http.usecases.RemoteCryptoFeedLoader

class RemoteCryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): com.singaludra.featurefeed.domain.CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
            )
        }
    }
}