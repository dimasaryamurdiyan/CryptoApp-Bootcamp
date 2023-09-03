package com.hightech.cryptoapp.crypto.feed.http

import com.singaludra.featurefeed.domain.RemoteRootCryptoFeed
import kotlinx.coroutines.flow.Flow

sealed class HttpClientResult {
    data class Success(val root: RemoteRootCryptoFeed) : HttpClientResult()
    data class Failure(val throwable: Throwable) : HttpClientResult()
}

class InvalidDataException : Throwable()
class ConnectivityException : Throwable()

interface CryptoFeedHttpClient {
    fun get(): Flow<HttpClientResult>
}