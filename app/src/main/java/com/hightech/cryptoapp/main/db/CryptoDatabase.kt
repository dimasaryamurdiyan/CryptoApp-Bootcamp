package com.hightech.cryptoapp.main.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity
import com.hightech.cryptoapp.crypto.feed.db.room.CryptoFeedDao

@Database(entities = [CryptoFeedEntity::class], version = 2, exportSchema = false)
abstract class CryptoFeedDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao
}