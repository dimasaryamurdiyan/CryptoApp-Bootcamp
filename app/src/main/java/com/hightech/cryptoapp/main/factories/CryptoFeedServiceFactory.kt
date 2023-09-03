package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.frameworks.HttpFactory
import com.singaludra.featurefeed.http.CryptoFeedService

class CryptoFeedServiceFactory {
    companion object {
        fun createCryptoFeedService(): com.singaludra.featurefeed.http.CryptoFeedService {
            return HttpFactory.createRetrofit(
                HttpFactory.createMoshi(),
                HttpFactory.createOkhttpClient(
                    HttpFactory.createLoggingInterceptor()
                )
            ).create(com.singaludra.featurefeed.http.CryptoFeedService::class.java)
        }
    }
}