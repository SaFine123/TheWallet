package com.douglasqueiroz.thewallet.feature.home

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


fun NavHostController.navigateToHome() {
    val startDestination = this.graph.findStartDestination()
    this.navigate("home") {
        popUpTo(startDestination.id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.homeScreen() {
    composable("home") {
        HomeScreen()
    }
}