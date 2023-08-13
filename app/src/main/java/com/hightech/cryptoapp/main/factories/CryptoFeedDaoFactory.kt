package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.MyApplication
import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao
import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDatabase
import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedHttpClient
import com.hightech.cryptoapp.crypto.feed.http.CryptoFeedRetrofitHttpClient

class CryptoFeedDaoFactory {
    companion object {
        fun createCryptoFeedDao(): CryptoFeedDao {
            return CryptoFeedDatabase.getDatabase(provideApplication()).cryptoFeedDao()
        }

        fun provideApplication(): MyApplication {
            return MyApplication.instance!!
        }
    }
}