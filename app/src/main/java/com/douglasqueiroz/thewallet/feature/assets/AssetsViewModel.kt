package com.douglasqueiroz.thewallet.feature.assets

import androidx.lifecycle.ViewModel
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClick
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClickImpl
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

class AssetsViewModel(
    private val navRouter: NavRouter
): ViewModel(), OnBottomBarClick by OnBottomBarClickImpl(navRouter) {
}