package com.tantawy.warbabankpoc.domain.usecases

import com.tantawy.warbabankpoc.data.models.Products
import com.tantawy.warbabankpoc.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val productsRepository: ProductsRepository) :
    UseCase<Boolean, Flow<ArrayList<Products>>> {
    override suspend fun execute(fromCash: Boolean?): Flow<ArrayList<Products>> {
        return fetchProducts()
    }

    private suspend fun fetchProducts(): Flow<ArrayList<Products>> {
        return productsRepository.fetchProducts()
    }
}