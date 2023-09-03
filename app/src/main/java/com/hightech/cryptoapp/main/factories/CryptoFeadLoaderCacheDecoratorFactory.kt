package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedCache
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.main.decorators.CryptoFeedLoaderCacheDecorator

class CryptoFeedLoaderCacheDecoratorFactory {
    companion object{
        fun createCryptoFeedLoaderDecorator(
            decorate: CryptoFeedLoader,
            cache: CryptoFeedCache
        ): CryptoFeedLoader{
            return CryptoFeedLoaderCacheDecorator(
                decorate = decorate,
                cache = cache
            )
        }
    }
}