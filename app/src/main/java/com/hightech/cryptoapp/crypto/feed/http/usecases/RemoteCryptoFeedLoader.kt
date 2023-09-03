package com.hightech.cryptoapp.crypto.feed.http.usecases

import android.util.Log
import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import com.hightech.cryptoapp.crypto.feed.http.ConnectivityException
import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedHttpClient
import com.hightech.cryptoapp.crypto.feed.http.HttpClientResult
import com.hightech.cryptoapp.crypto.feed.http.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteCryptoFeedLoader constructor(
    private val cryptoFeedHttpClient: CryptoFeedHttpClient,
):
    com.singaludra.featurefeed.domain.CryptoFeedLoader {
    override fun load(): Flow<com.singaludra.featurefeed.domain.CryptoFeedResult> = flow {
        cryptoFeedHttpClient.get().collect { result ->
            when (result) {
                is HttpClientResult.Success -> {
                    val cryptoFeed = result.root.data
                    if (cryptoFeed.isNotEmpty()) {
                        emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Success(com.singaludra.featurefeed.domain.CryptoFeedItemsMapper.map(cryptoFeed)))
                    } else {
                        emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Success(emptyList()))
                    }
                }

                is HttpClientResult.Failure -> {
                    Log.d("loadCryptoFeed", "Failure")
                    when (result.throwable) {
                        is ConnectivityException -> {
                            emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Failure(Connectivity()))
                        }

                        is InvalidDataException -> {
                            Log.d("loadCryptoFeed", "InvalidData")
                            emit(com.singaludra.featurefeed.domain.CryptoFeedResult.Failure(InvalidData()))
                        }
                    }
                }
            }
        }
    }
}

class InvalidData : Throwable()
class Connectivity : Throwable()