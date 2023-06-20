package com.douglasqueiroz.thewallet.feature.currencydetails.logic

sealed class CurrencyDetailsEvent {
    class OnNameChange(val newValue: String): CurrencyDetailsEvent()
    class OnSymbolChange(val newValue: String): CurrencyDetailsEvent()
    class OnDefaultCurrencyChange(val newValue: Boolean): CurrencyDetailsEvent()
    object OnSave: CurrencyDetailsEvent()
    object OnCancel: CurrencyDetailsEvent()
}
