package com.douglasqueiroz.thewallet.ui.navigation

import androidx.navigation.NavHostController

class NavRouter (
    val  navHostController: NavHostController
) {
    fun navigateUp() {
        navHostController.navigateUp()
    }
}