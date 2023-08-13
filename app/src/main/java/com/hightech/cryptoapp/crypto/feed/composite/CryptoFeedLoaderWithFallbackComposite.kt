package com.hightech.cryptoapp.crypto.feed.composite

import android.util.Log
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
            try {
                primary.load()
            } catch (e: Exception){
                fallback.load()
            }
        }
    }
}