package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.http.CryptoFeedHttpClient
import com.singaludra.featurefeed.http.CryptoFeedRetrofitHttpClient

class CryptoFeedHttpClientFactory {
    companion object {
        fun createCryptoFeedHttpClient(): CryptoFeedHttpClient {
            return CryptoFeedRetrofitHttpClient(
                CryptoFeedServiceFactory.createCryptoFeedService()
            )
        }
    }
}