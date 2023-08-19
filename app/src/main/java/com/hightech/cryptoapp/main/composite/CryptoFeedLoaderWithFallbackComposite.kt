package com.hightech.cryptoapp.main.composite

import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedLoader
import com.hightech.cryptoapp.crypto.feed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderWithFallbackComposite(
    private val primary: CryptoFeedLoader,
    private val fallback: CryptoFeedLoader,
): CryptoFeedLoader {
    override fun load(): Flow<CryptoFeedResult> {
        return flow {
            primary.load().collect{ result ->
                when (result) {
                    is CryptoFeedResult.Success -> emit(result)

                    is CryptoFeedResult.Failure -> {
                        fallback.load().collect { emit(it) }
                    }
                }
            }
        }
    }
}