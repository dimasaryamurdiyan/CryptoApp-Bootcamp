package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.domain.CryptoFeedCache
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.main.decorators.CryptoFeedLoaderCacheDecorator

class CryptoFeedLoaderCacheDecoratorFactory {
    companion object{
        fun createCryptoFeedLoaderDecorator(
            decorate: com.singaludra.featurefeed.domain.CryptoFeedLoader,
            cache: com.singaludra.featurefeed.domain.CryptoFeedCache
        ): com.singaludra.featurefeed.domain.CryptoFeedLoader {
            return CryptoFeedLoaderCacheDecorator(
                decorate = decorate,
                cache = cache
            )
        }
    }
}