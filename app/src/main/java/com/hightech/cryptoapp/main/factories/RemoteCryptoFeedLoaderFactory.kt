package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.http.usecases.RemoteCryptoFeedLoader

class RemoteCryptoFeedLoaderFactory {
    companion object {
        fun createRemoteCryptoFeedLoader(): CryptoFeedLoader {
            return RemoteCryptoFeedLoader(
                CryptoFeedHttpClientFactory.createCryptoFeedHttpClient(),
            )
        }
    }
}