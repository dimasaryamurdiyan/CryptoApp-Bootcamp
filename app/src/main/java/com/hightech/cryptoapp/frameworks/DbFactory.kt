package com.hightech.cryptoapp.frameworks

import android.content.Context
import androidx.room.Room
import com.hightech.cryptoapp.MyApplication
import com.hightech.cryptoapp.main.db.CryptoFeedDatabase

object DbFactory {
    lateinit var application: MyApplication
    @Volatile
    private var INSTANCE: CryptoFeedDatabase? = null

    fun getDatabase(): CryptoFeedDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(this) {
            val instance = Room.databaseBuilder(
                application.applicationContext,
                CryptoFeedDatabase::class.java,
                "crypto_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}