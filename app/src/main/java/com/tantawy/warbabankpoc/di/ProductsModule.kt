package com.tantawy.warbabankpoc.di

import com.tantawy.warbabankpoc.data.api.ProductsApi
import com.tantawy.warbabankpoc.domain.repository.ProductsRepository
import com.tantawy.warbabankpoc.domain.usecases.GetProductsUseCase
import com.tantawy.warbabankpoc.presentation.viewmodels.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val  catalogModule = module {

    factory { get<Retrofit>().create(ProductsApi::class.java)}
    factory { GetProductsUseCase(get()) }
    factory { ProductsRepository(get()) }
    viewModel { ProductsViewModel(get()) }
}