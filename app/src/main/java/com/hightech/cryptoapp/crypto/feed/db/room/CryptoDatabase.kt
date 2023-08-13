package com.hightech.cryptoapp.crypto.feed.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity

@Database(entities = [CryptoFeedEntity::class], version = 1, exportSchema = false)
abstract class CryptoFeedDatabase : RoomDatabase() {
    abstract fun cryptoFeedDao(): CryptoFeedDao

    companion object {
        @Volatile
        private var INSTANCE: CryptoFeedDatabase? = null

        fun getDatabase(context: Context): CryptoFeedDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoFeedDatabase::class.java,
                    "crypto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}