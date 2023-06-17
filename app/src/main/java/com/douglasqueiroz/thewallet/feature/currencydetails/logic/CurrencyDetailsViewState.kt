package com.douglasqueiroz.thewallet.feature.currencydetails.logic

data class CurrencyDetailsViewState(
    val currencyName: String = "",
    val currencyNameErrorMsg: String? = null,
    val currencySymbol: String = "",
    val currencySymbolErrorMsg: String? = null,
    val enableSave: Boolean = false,
    val defaultCurrency: Boolean = false
)
