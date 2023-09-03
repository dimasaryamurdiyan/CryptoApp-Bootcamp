package com.hightech.cryptoapp.main.decorators

import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity.Companion.fromDomain
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedCache
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
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