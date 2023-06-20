package com.douglasqueiroz.thewallet.feature.currencylist.state

data class CurrencyItemState(
    val currencyId: Int,
    val currencyName: String = "",
    val currencySymbol: String = "",
    val defaultCurrency: Boolean = false
)