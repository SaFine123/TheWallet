package com.douglasqueiroz.thewallet.feature.home

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.androidx.compose.koinViewModel


fun NavRouter.navigateToHome() {
    val startDestination = this.navHostController.graph.findStartDestination()
    this.navHostController.navigate("home") {
        popUpTo(startDestination.id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.homeScreen() {
    composable("home") {

        val viewModel = koinViewModel<HomeViewModel>()

        HomeScreen(
            onBottomBarClick = viewModel::onBottomBarClick
        )
    }
}