package com.douglasqueiroz.thewallet.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val symbol: String,
    val defaultCurrency: Boolean
)
