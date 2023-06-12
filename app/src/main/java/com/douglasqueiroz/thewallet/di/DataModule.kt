package com.douglasqueiroz.thewallet.di

import android.app.Application
import androidx.room.Room
import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.setup.TheWalletDatabase
import org.koin.dsl.module

object DataModule {

    fun get(application: Application) = module {

        val db = Room.databaseBuilder(
            application,
            TheWalletDatabase::class.java, "the-wallet-database"
        ).build()

        factory { db.currencyDao }
    }
}