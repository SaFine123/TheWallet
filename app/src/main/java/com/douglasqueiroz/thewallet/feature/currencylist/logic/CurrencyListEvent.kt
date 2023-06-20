package com.douglasqueiroz.thewallet.feature.currencylist.logic

sealed class CurrencyListEvent {
    object OnInsert: CurrencyListEvent()
    class OnSelectCurrency(val currencyId: Int): CurrencyListEvent()
}
