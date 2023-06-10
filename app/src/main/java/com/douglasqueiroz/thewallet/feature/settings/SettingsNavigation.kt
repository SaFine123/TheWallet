package com.douglasqueiroz.thewallet.feature.settings

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.androidx.compose.koinViewModel

fun NavRouter.navigateToSettings() {
    val startDestination = this.navHostController.graph.findStartDestination()

    this.navHostController.navigate("settings") {
        popUpTo(startDestination.id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.settingsScreen() {
    composable("settings") {

        val viewModel = koinViewModel<SettingsViewModel>()

        SettingsScreen(
            onEvent = viewModel::onEvent,
            onBottomBarClick = viewModel::onBottomBarClick
        )
    }
}