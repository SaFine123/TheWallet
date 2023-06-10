package com.douglasqueiroz.thewallet.feature.currencylist.logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyListViewState
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClick
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClickImpl
import com.douglasqueiroz.thewallet.ui.components.OnTopBarClick
import com.douglasqueiroz.thewallet.ui.components.OnTopBarClickImp
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

class CurrencyListViewModel(
    navRouter: NavRouter
): ViewModel(),
    OnBottomBarClick by OnBottomBarClickImpl(navRouter),
        OnTopBarClick by OnTopBarClickImp(navRouter)
{

    var state by mutableStateOf(CurrencyListViewState())
    private set


}