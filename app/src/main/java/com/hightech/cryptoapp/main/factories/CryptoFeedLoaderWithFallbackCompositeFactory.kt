package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.main.composite.CryptoFeedLoaderWithFallbackComposite
import com.singaludra.featurefeed.domain.CryptoFeedLoader

class CryptoFeedLoaderWithFallbackCompositeFactory {
    companion object {
        fun createCryptoFeedLoaderWithFallbackComposite(
            primary: com.singaludra.featurefeed.domain.CryptoFeedLoader,
            fallback: com.singaludra.featurefeed.domain.CryptoFeedLoader
        ): com.singaludra.featurefeed.domain.CryptoFeedLoader {
            return CryptoFeedLoaderWithFallbackComposite(
                primary, fallback
            )
        }
    }
}