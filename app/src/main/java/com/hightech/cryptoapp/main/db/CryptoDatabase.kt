package com.hightech.cryptoapp.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.singaludra.featurefeed.cache.room.CryptoFeedDao
import com.singaludra.featurefeed.domain.CryptoFeedEntity

@Database(entities = [CryptoFeedEntity::class], version = 2, exportSchema = false)
abstract class CryptoFeedDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao
}