package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.feature.currencydetails.logic.CurrencyDetailsViewState
import com.douglasqueiroz.thewallet.feature.currencydetails.view.CurrencyDetailsView
import com.douglasqueiroz.thewallet.feature.currencydetails.logic.CurrencyDetailsEvent
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyListEvent
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyItemState
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyListViewState
import com.douglasqueiroz.thewallet.ui.components.TheWalletBottomBar
import com.douglasqueiroz.thewallet.ui.components.BottomBarItem
import com.douglasqueiroz.thewallet.ui.components.TheWalletTopBar
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyListScreen(
    state: CurrencyListViewState,
    currencyDetailsState: CurrencyDetailsViewState,
    currencyDetailsEvent: (CurrencyDetailsEvent) -> Unit,
    onBottomBarClick: (BottomBarItem) -> Unit = {  },
    onNavigateUp: () -> Unit = {  },
    onEvent: (CurrencyListEvent) -> Unit = {}
) {
    TheWalletTheme {

        if (state.showCurrencyDetailsDialog) {
            CurrencyDetailsView(
                state = currencyDetailsState,
                onEvent = currencyDetailsEvent
            )
        }

        Scaffold(
            topBar = {
                TheWalletTopBar(
                    title = R.string.currencylist_screen_title,
                    navigateUp = onNavigateUp
                )
            },
            bottomBar = {
                TheWalletBottomBar(onBottomBarClick = onBottomBarClick)
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { onEvent(CurrencyListEvent.OnInsert) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Currency"
                    )
                }
            }
        ) {
            CurrencyList(
                modifier = Modifier.padding(it),
                currencyList = state.currencyList,
                onEvent = onEvent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyListScreenPreview() {
    CurrencyListScreen(
        state = CurrencyListViewState(
            currencyList = listOf(
                CurrencyItemState(
                    currencyId = 0,
                    currencyName = "Brazilian Real",
                    currencySymbol = "R$",
                    defaultCurrency = false
                ),
                CurrencyItemState(
                    currencyId = 0,
                    currencyName = "US Dollar",
                    currencySymbol = "$",
                    defaultCurrency = true
                ),
                CurrencyItemState(
                    currencyId = 0,
                    currencyName = "Euro",
                    currencySymbol = "€",
                    defaultCurrency = false
                )
            ),
            showCurrencyDetailsDialog = false
        ),
        currencyDetailsState = CurrencyDetailsViewState(),
        currencyDetailsEvent = {}
    )
}