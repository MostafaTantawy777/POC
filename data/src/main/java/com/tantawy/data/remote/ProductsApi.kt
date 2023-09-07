package com.tantawy.data.remote

import com.tantawy.domain.model.Products
import retrofit2.http.*

interface ProductsApi {

    @GET("products/")
    suspend fun  getProducts(): ArrayList<Products>

}