package com.douglasqueiroz.thewallet.di

import androidx.navigation.NavHostController
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.dsl.module

object UtilModule {

    lateinit var getNavController: (() -> NavHostController)
    fun get() = module {
        factory {
            NavRouter(navHostController = getNavController())
        }
    }

}