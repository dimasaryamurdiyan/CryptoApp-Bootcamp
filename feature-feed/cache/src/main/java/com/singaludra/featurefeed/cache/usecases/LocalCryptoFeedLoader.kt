package com.singaludra.featurefeed.cache.usecases

import com.singaludra.featurefeed.cache.room.CryptoFeedDao
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LocalCryptoFeedLoader constructor(private val cryptoFeedDao: CryptoFeedDao):
    CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            try {
                val data = cryptoFeedDao.getAllCryptoFeedItems()
                if (data.isNullOrEmpty()) {
                    emit(CryptoFeedResult.Success(com.singaludra.featurefeed.domain.CryptoFeedItemsMapper.mapEntityToDomain(data)))
                }
            } catch (t : Throwable){
                emit(CryptoFeedResult.Failure(t))
            }
        }.flowOn(Dispatchers.IO)
    }
}