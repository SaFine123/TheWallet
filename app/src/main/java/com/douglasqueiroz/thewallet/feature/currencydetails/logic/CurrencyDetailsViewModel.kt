package com.douglasqueiroz.thewallet.feature.currencydetails.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.data.local.dao.CurrencyDao
import com.douglasqueiroz.thewallet.data.local.model.Currency
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyDetailsEvent
import com.douglasqueiroz.thewallet.util.StringResUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrencyDetailsViewModel(
    private val stringResUtil: StringResUtil,
    private val currencyDao: CurrencyDao
): ViewModel() {

    var onShowDialog: ((Boolean) -> Unit)? = null
    var currency: Currency? = null
        set(value) {
            value?.let { populateCurrency(it) }

            field = value
        }

    private val _state = MutableStateFlow(CurrencyDetailsViewState())
    val state = _state.asStateFlow()

    private fun populateCurrency(currency: Currency) {
        _state.value = _state.value.copy(
            currencyName = currency.name,
            currencySymbol =  currency.symbol,
            defaultCurrency = currency.defaultCurrency
        )
    }

    fun onEvent(event: CurrencyDetailsEvent) {
        when(event) {
            is CurrencyDetailsEvent.OnNameChange -> onChangeCurrencyName(event.newValue)
            is CurrencyDetailsEvent.OnSymbolChange -> onChangeCurrencySymbol(event.newValue)
            is CurrencyDetailsEvent.OnDefaultCurrencyChange -> onChangeCurrencyDefault(event.newValue)
            is CurrencyDetailsEvent.OnCancel -> onCancel()
            is CurrencyDetailsEvent.OnSave -> onSave()
        }
    }

    private fun onChangeCurrencyName(name: String) {

        val errorMessage = if (name.isEmpty()) {
            stringResUtil.getString(R.string.mandatory_field_error)
        } else {
            null
        }

        _state.value = _state.value.copy(
            currencyName = name,
            currencyNameErrorMsg = errorMessage,
            enableSave = name.isNotEmpty() && _state.value.currencySymbol.isNotEmpty()
        )
    }

    private fun onChangeCurrencySymbol(symbol: String) {

        val errorMessage = if (symbol.isEmpty()) {
            stringResUtil.getString(R.string.mandatory_field_error)
        } else {
            null
        }

        _state.value = _state.value.copy(
            currencySymbol = symbol,
            currencySymbolErrorMsg = errorMessage,
            enableSave = symbol.isNotEmpty() && _state.value.currencyName.isNotEmpty()
        )
    }

    private fun onChangeCurrencyDefault(newValue: Boolean) {
        _state.value = _state.value.copy(
            defaultCurrency = newValue
        )
    }

    private fun onCancel() {
        onShowDialog?.invoke(false)
    }

    private fun onSave() = viewModelScope.launch {
        val currency = Currency(
            id = this@CurrencyDetailsViewModel.currency?.id ?: 0,
            name = _state.value.currencyName,
            symbol = _state.value.currencySymbol,
            defaultCurrency = _state.value.defaultCurrency
        )

        currencyDao.upset(currency = currency)

        onShowDialog?.invoke(false)
    }
}