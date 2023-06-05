package com.douglasqueiroz.thewallet.feature.settings

sealed class SettingsEvent {
    object OnCurrencyClick: SettingsEvent()
}
