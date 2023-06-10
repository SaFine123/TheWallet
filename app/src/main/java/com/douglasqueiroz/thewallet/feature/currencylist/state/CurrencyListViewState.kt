package com.douglasqueiroz.thewallet.feature.currencylist.state

data class CurrencyListViewState(
    val currencyList: List<CurrencyItemState> = emptyList()
)
