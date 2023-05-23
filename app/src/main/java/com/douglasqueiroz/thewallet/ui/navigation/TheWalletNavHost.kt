package com.douglasqueiroz.thewallet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.douglasqueiroz.thewallet.feature.assets.assetsScreen
import com.douglasqueiroz.thewallet.feature.home.homeScreen
import com.douglasqueiroz.thewallet.feature.settings.settingsScreen

@Composable
fun TheWalletNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "home"
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        homeScreen()

        assetsScreen()

        settingsScreen()
    }

}