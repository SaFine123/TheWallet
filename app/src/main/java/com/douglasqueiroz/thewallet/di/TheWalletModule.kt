package com.douglasqueiroz.thewallet.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object TheWalletModule {

    fun startKoin(application: Application) = startKoin {
        androidContext(application)
        modules(
            listOf(
                UtilModule.get(),
                ViewModelModule.get(),
                DataModule.get(application)
            )
        )
    }
}