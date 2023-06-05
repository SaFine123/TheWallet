package com.douglasqueiroz.thewallet.feature.settings

import androidx.lifecycle.ViewModel
import com.douglasqueiroz.thewallet.feature.currencylist.navigateToCurrencyList
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

class SettingsViewModel(
    private val navRouter: NavRouter
): ViewModel() {

    fun onEvent(event: SettingsEvent) {

        when(event) {
            SettingsEvent.OnCurrencyClick -> navRouter.navigateToCurrencyList()
        }
    }
}