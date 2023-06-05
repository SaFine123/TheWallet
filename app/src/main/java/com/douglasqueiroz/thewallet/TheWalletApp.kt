package com.douglasqueiroz.thewallet

import android.app.Application
import com.douglasqueiroz.thewallet.di.TheWalletModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheWalletApp: Application() {

    override fun onCreate() {
        super.onCreate()

        TheWalletModule.startKoin(this)
    }
}