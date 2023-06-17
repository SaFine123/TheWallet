package com.douglasqueiroz.thewallet.feature.currencylist.logic

sealed class CurrencyDetailsEvent {
    class OnNameChange(val newValue: String): CurrencyDetailsEvent()
    class OnSymbolChange(val newValue: String): CurrencyDetailsEvent()
    object OnSave: CurrencyDetailsEvent()
    object OnCancel: CurrencyDetailsEvent()
}
