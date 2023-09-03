package com.hightech.cryptoapp.crypto.feed.db.usecases

import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.usecases.Connectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LocalCryptoFeedLoader constructor(private val cryptoFeedDao: CryptoFeedDao):
    com.singaludra.featurefeed.domain.CryptoFeedLoader {
    override fun load(): Flow<com.singaludra.featurefeed.domain.CryptoFeedResult> {
        return flow {
            try {
                val data = cryptoFeedDao.getAllCryptoFeedItems()
                if (data.isNullOrEmpty()) {
                    emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Success(com.singaludra.featurefeed.domain.CryptoFeedItemsMapper.mapEntityToDomain(data)))
                }
            } catch (t : Throwable){
                emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Failure(Connectivity()))
            }
        }.flowOn(Dispatchers.IO)
    }
}