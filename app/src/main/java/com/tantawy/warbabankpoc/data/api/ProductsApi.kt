package com.tantawy.warbabankpoc.data.api

import com.tantawy.warbabankpoc.data.models.Products
import retrofit2.http.*

interface ProductsApi {

    @GET("products/")
    suspend fun  getProducts(): ArrayList<Products>

}