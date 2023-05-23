package com.douglasqueiroz.thewallet.feature.assets

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavHostController.navigateToAssets() {
    this.navigate("assets") {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
//        popUpTo(this.graph.findStartDestination().id) {
//            saveState = true
//        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}

fun NavGraphBuilder.assetsScreen() {
    composable("assets") {
        AssetsScreen()
    }
}