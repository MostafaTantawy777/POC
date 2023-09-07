package com.tantawy.warbabankpoc.di

import com.tantawy.warbabankpoc.presentation.viewmodels.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  viewModelsModule = module {
    viewModel { ProductsViewModel(get()) }
}