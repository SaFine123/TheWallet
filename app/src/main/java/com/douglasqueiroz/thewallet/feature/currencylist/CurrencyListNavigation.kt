package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

fun NavRouter.navigateToCurrencyList() {
    navHostController.navigate("CurrencyList")
}

fun NavGraphBuilder.currencyListScreen() {
    composable("CurrencyList") {
        CurrencyListScreen()
    }
}