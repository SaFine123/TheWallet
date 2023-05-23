package com.douglasqueiroz.thewallet.feature.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavController.navigateToSettings() {
    this.navigate("settings")
}

fun NavGraphBuilder.settingsScreen() {
    composable("settings") {
        SettingsScreen()
    }
}