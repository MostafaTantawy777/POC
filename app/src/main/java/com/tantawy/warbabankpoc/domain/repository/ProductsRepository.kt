package com.tantawy.warbabankpoc.domain.repository

import com.tantawy.warbabankpoc.data.api.ProductsApi
import com.tantawy.warbabankpoc.data.models.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepository(private val productsApi: ProductsApi) {

    suspend fun fetchProducts(): Flow<ArrayList<Products>> {
        val obj = productsApi.getProducts()
        return flow {
            emit(obj)
        }
    }
}