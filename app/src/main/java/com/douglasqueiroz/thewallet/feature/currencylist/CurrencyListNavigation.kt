package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.douglasqueiroz.thewallet.feature.currencydetails.logic.CurrencyDetailsViewModel
import com.douglasqueiroz.thewallet.feature.currencydetails.logic.CurrencyDetailsViewState
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyListViewModel
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import org.koin.androidx.compose.koinViewModel

fun NavRouter.navigateToCurrencyList() {
    navHostController.navigate("CurrencyList")
}

fun NavGraphBuilder.currencyListScreen() {
    composable("CurrencyList") {
        val viewModel = koinViewModel<CurrencyListViewModel>()
        val currencyDetailsViewModel = koinViewModel<CurrencyDetailsViewModel>()

        currencyDetailsViewModel.onShowDialog = {
            viewModel.closeCurrencyDetailsDialog()
        }

        viewModel.setCurrencyToDetailsDialog = {
            currencyDetailsViewModel.currency = it
        }

        val state by viewModel.stateFlow.collectAsState()
        val currencyDetailsState by currencyDetailsViewModel.state.collectAsState()

        CurrencyListScreen(
            state = state,
            onNavigateUp = viewModel::navigateUp,
            onBottomBarClick = viewModel::onBottomBarClick,
            addCurrency = viewModel::insert,
            currencyDetailsState = currencyDetailsState,
            currencyDetailsEvent = currencyDetailsViewModel::onEvent
        )
    }
}