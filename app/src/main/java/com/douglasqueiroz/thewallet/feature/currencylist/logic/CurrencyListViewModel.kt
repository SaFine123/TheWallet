package com.douglasqueiroz.thewallet.feature.currencylist.logic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyItemState
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyListViewState
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClick
import com.douglasqueiroz.thewallet.ui.components.OnBottomBarClickImpl
import com.douglasqueiroz.thewallet.ui.components.OnTopBarClick
import com.douglasqueiroz.thewallet.ui.components.OnTopBarClickImp
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import kotlinx.coroutines.launch

class CurrencyListViewModel(
    navRouter: NavRouter,
    private val currencyDao: CurrencyDao
): ViewModel(),
    OnBottomBarClick by OnBottomBarClickImpl(navRouter),
    OnTopBarClick by OnTopBarClickImp(navRouter)
{

    var state by mutableStateOf(CurrencyListViewState())
    private set

    init {
        loadCurrencies()
    }

    fun insert() = viewModelScope.launch {
        val currency = Currency(
            name = "Currency A",
            symbol = "AA",
            defaultCurrency = false
        )

        currencyDao.upset(currency)
    }

    fun loadCurrencies() = viewModelScope.launch {
        currencyDao.getAll().collect { currencyList ->
            val currencyItems = currencyList.map {
                CurrencyItemState(
                    currencyName = it.name,
                    currencySymbol = it.symbol
                )
            }

            state = state.copy(currencyList = currencyItems)
        }
    }




}