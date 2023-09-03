package com.hightech.cryptoapp.main.decorators

import com.singaludra.featurefeed.domain.CryptoFeedCache
import com.singaludra.featurefeed.domain.CryptoFeedEntity.Companion.fromDomain
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderCacheDecorator constructor(
    private val decorate: CryptoFeedLoader,
    private val cache: CryptoFeedCache
): CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            decorate.load().collect{cryptoFeedResult ->
                if(cryptoFeedResult is CryptoFeedResult.Success){
                    val cryptoFeed = cryptoFeedResult.cryptoFeedItems
                    cache.insertAll(*cryptoFeed.fromDomain().toTypedArray())
                }
                emit(cryptoFeedResult)
            }
        }
    }

}