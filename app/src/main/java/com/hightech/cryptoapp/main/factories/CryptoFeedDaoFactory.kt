package com.hightech.cryptoapp.main.factories

import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao
import com.hightech.cryptoapp.frameworks.DbFactory

class CryptoFeedDaoFactory {
    companion object {
        fun createCryptoFeedDao(): CryptoFeedDao {
            return DbFactory.getDatabase().cryptoFeedDao()
        }


    }
}