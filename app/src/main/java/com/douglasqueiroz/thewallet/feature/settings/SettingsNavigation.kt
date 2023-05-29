package com.douglasqueiroz.thewallet.feature.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavController.navigateToSettings() {
    val startDestination = this.graph.findStartDestination()
    this.navigate("settings") {
        popUpTo(startDestination.id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.settingsScreen() {
    composable("settings") {
        SettingsScreen()
    }
}