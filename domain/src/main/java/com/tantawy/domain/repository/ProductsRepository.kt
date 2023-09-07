package com.tantawy.domain.repository

import com.tantawy.domain.model.Products
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun fetchProducts(): Flow<ArrayList<Products>>
}