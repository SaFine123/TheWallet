package com.douglasqueiroz.thewallet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.douglasqueiroz.thewallet.di.UtilModule
import com.douglasqueiroz.thewallet.feature.assets.assetsScreen
import com.douglasqueiroz.thewallet.feature.currencylist.currencyListScreen
import com.douglasqueiroz.thewallet.feature.home.homeScreen
import com.douglasqueiroz.thewallet.feature.settings.settingsScreen

@Composable
fun TheWalletNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        UtilModule.getNavController = {
            navController
        }

        homeScreen()

        assetsScreen()

        settingsScreen()

        currencyListScreen()
    }

}

