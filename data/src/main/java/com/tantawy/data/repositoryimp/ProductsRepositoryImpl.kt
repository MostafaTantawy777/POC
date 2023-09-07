package com.tantawy.data.repositoryimp

import android.util.Log
import com.tantawy.data.remote.ProductsApi
import com.tantawy.domain.model.Products
import com.tantawy.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepositoryImpl(private val productsApi: ProductsApi) : ProductsRepository {

    override suspend fun fetchProducts(): Flow<ArrayList<Products>> {
        val obj = productsApi.getProducts()
        return flow {
            emit(obj)
        }
    }
}