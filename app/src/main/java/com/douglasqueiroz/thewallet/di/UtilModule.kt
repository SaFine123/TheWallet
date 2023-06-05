package com.douglasqueiroz.thewallet.di

import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.dsl.module

object UtilModule {
    fun get() = module {
        single {
            NavRouter()
        }
    }

}