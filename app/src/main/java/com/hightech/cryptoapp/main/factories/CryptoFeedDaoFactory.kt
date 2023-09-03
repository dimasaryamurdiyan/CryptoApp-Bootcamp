package com.hightech.cryptoapp.main.factories

import com.singaludra.featurefeed.cache.room.CryptoFeedDao
import com.hightech.cryptoapp.frameworks.DbFactory

class CryptoFeedDaoFactory {
    companion object {
        fun createCryptoFeedDao(): com.singaludra.featurefeed.cache.room.CryptoFeedDao {
            return DbFactory.getDatabase().cryptoFeedDao()
        }


    }
}