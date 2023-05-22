package com.douglasqueiroz.thewallet.data.local.setup

import androidx.room.Database
import androidx.room.RoomDatabase
import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.model.Currency

@Database(
    entities = [Currency::class],
    version = 1
)
abstract class TheWalletDatabase: RoomDatabase() {

    abstract val currencyDao: CurrencyDao
}