package com.hightech.cryptoapp.crypto.feed.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.singaludra.featurefeed.domain.CryptoFeedItem

@Entity(tableName = "crypto_feed")
data class CryptoFeedEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "full_name")
    val fullName: String?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @ColumnInfo(name = "price")
    val price: Double?,
    @ColumnInfo(name = "changepctday")
    val changePctDay: Float
){
    companion object{
        fun List<com.singaludra.featurefeed.domain.CryptoFeedItem>.fromDomain(): List<CryptoFeedEntity> {
            return this.map {
                CryptoFeedEntity(
                    id = it.coinInfo.id,
                    name = it.coinInfo.name,
                    fullName = it.coinInfo.fullName,
                    imageUrl = it.coinInfo.imageUrl,
                    price = it.raw.usd.price,
                    changePctDay = it.raw.usd.changePctDay,
                )
            }
        }
    }
}
