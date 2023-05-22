package com.douglasqueiroz.thewallet.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.douglasqueiroz.thewallet.data.local.model.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Upsert
    fun upset(currency: Currency)

    @Delete
    fun delete(currency: Currency)

    @Query("SELECT * FROM Currency")
    fun getAll(): Flow<List<Currency>>
}