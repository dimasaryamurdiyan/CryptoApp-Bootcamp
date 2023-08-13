package com.hightech.cryptoapp.crypto.feed.db.usecases

import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedItemsMapper
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedHttpClient
import com.hightech.cryptoapp.crypto.feed.http.usecases.Connectivity
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
                    emit(CryptoFeedResult.Success(CryptoFeedItemsMapper.mapEntityToDomain(data)))
                }
            } catch (t : Throwable){
                emit(CryptoFeedResult.Failure(Connectivity()))
            }
        }.flowOn(Dispatchers.IO)
    }
}