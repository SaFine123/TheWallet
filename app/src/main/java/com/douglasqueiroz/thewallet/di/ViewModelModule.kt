package com.douglasqueiroz.thewallet.di

import com.douglasqueiroz.thewallet.feature.assets.AssetsViewModel
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyListViewModel
import com.douglasqueiroz.thewallet.feature.home.HomeViewModel
import com.douglasqueiroz.thewallet.feature.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    fun get() = module {

        viewModel {
            HomeViewModel(
                navRouter = get()
            )
        }

        viewModel {
            AssetsViewModel(get())
        }

        viewModel {
            SettingsViewModel(get())
        }

        viewModel {
            CurrencyListViewModel(get())
        }
    }
}