package com.tantawy.domain.di

import com.tantawy.domain.usecases.GetProductsUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetProductsUseCase(get()) }
}