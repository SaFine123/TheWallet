package com.douglasqueiroz.thewallet.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavController.navigateToHome() {
    this.navigate("home")
}

fun NavGraphBuilder.homeScreen() {
    composable("home") {
        HomeScreen()
    }
}