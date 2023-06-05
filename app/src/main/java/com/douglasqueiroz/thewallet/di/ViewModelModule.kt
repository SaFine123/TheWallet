package com.douglasqueiroz.thewallet.di

import com.douglasqueiroz.thewallet.feature.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    fun get() = module {
        viewModel {
            SettingsViewModel(
                navRouter = get()
            )
        }
    }
}