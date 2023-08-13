package com.hightech.cryptoapp.crypto.feed.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hightech.cryptoapp.crypto.feed.db.entity.CryptoFeedEntity

@Dao
interface CryptoFeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoFeedItems: List<CryptoFeedEntity>)

    @Query("SELECT * FROM crypto_feed")
    suspend fun getAllCryptoFeedItems(): List<CryptoFeedEntity>
}