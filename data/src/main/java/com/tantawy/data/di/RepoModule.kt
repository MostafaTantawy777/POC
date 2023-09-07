package com.tantawy.data.di

import com.tantawy.data.repositoryimp.ProductsRepositoryImpl
import com.tantawy.domain.repository.ProductsRepository
import org.koin.dsl.module
val repoModule = module {
    single<ProductsRepository> { ProductsRepositoryImpl(get()) }
}