package com.douglasqueiroz.thewallet.feature.currencylist.logic

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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CurrencyListViewModel(
    navRouter: NavRouter,
    private val currencyDao: CurrencyDao
): ViewModel(),
    OnBottomBarClick by OnBottomBarClickImpl(navRouter),
    OnTopBarClick by OnTopBarClickImp(navRouter)
{

    var setCurrencyToDetailsDialog: ((Currency?) -> Unit)? = null

    private val _stateFlow = MutableStateFlow(CurrencyListViewState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        loadCurrencies()
    }

    fun insert() = viewModelScope.launch {
        setCurrencyToDetailsDialog?.invoke(null)
        _stateFlow.value = _stateFlow.value.copy(
            showCurrencyDetailsDialog = true
        )
    }

    fun edit(currency: Currency) {
        setCurrencyToDetailsDialog?.invoke(currency)
        _stateFlow.value = _stateFlow.value.copy(
            showCurrencyDetailsDialog = true
        )
    }

    fun closeCurrencyDetailsDialog() {
        _stateFlow.value = _stateFlow.value.copy(
            showCurrencyDetailsDialog = false
        )
    }

    private fun loadCurrencies() = viewModelScope.launch {
        currencyDao.getAll().map { currencyList ->
            val currencyItems = currencyList.map {
                CurrencyItemState(
                    currencyName = it.name,
                    currencySymbol = it.symbol,
                    defaultCurrency = it.defaultCurrency
                )
            }

            _stateFlow.value = _stateFlow.value.copy(currencyList = currencyItems)
        }.stateIn(this)
    }
}