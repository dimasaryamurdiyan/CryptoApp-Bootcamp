package com.hightech.cryptoapp.main.composite

import com.singaludra.featurefeed.domain.CryptoFeedLoader
import com.singaludra.featurefeed.domain.CryptoFeedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CryptoFeedLoaderWithFallbackComposite(
    private val primary: com.singaludra.featurefeed.domain.CryptoFeedLoader,
    private val fallback: com.singaludra.featurefeed.domain.CryptoFeedLoader,
): com.singaludra.featurefeed.domain.CryptoFeedLoader {
    override fun load(): Flow<com.singaludra.featurefeed.domain.CryptoFeedResult> {
        return flow {
            primary.load().collect{ result ->
                when (result) {
                    is com.singaludra.featurefeed.domain.CryptoFeedResult.Success -> emit(result)

                    is com.singaludra.featurefeed.domain.CryptoFeedResult.Failure -> {
                        fallback.load().collect { emit(it) }
                    }
                }
            }
        }
    }
}