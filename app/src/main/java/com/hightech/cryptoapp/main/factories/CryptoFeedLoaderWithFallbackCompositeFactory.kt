package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.main.composite.CryptoFeedLoaderWithFallbackComposite
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader

class CryptoFeedLoaderWithFallbackCompositeFactory {
    companion object {
        fun createCryptoFeedLoaderWithFallbackComposite(
            primary: CryptoFeedLoader,
            fallback: CryptoFeedLoader
        ): CryptoFeedLoader {
            return CryptoFeedLoaderWithFallbackComposite(
                primary, fallback
            )
        }
    }
}