package com.jimd.randomuserapp.di

import com.jimd.randomuserapp.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(),get()) }
}