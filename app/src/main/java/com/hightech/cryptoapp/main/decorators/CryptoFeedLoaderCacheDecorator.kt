package com.hightech.cryptoapp.main.decorators

import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity.Companion.fromDomain
import com.singaludra.featurefeed.domain.CryptoFeedCache
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderCacheDecorator constructor(
    private val decorate: com.singaludra.featurefeed.domain.CryptoFeedLoader,
    private val cache: com.singaludra.featurefeed.domain.CryptoFeedCache
): com.singaludra.featurefeed.domain.CryptoFeedLoader {
    override fun load(): Flow<com.singaludra.featurefeed.domain.CryptoFeedResult> {
        return flow {
            decorate.load().collect{cryptoFeedResult ->
                if(cryptoFeedResult is com.singaludra.featurefeed.domain.CryptoFeedResult.Success){
                    val cryptoFeed = cryptoFeedResult.cryptoFeedItems
                    cache.insertAll(*cryptoFeed.fromDomain().toTypedArray())
                }
                emit(cryptoFeedResult)
            }
        }
    }

}