package com.singaludra.featurefeed.cache.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.singaludra.featurefeed.domain.CryptoFeedEntity

@Dao
interface CryptoFeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg cryptoFeedEntity: CryptoFeedEntity)

    @Query("SELECT * FROM crypto_feed")
    suspend fun getAllCryptoFeedItems(): List<CryptoFeedEntity>
}