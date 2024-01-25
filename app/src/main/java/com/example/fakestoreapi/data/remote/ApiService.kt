package com.example.fakestoreapi.data.remote

import com.example.fakestoreapi.domain.model.AllProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProducts(): Response<List<AllProductItem>>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/{productId}")
    suspend fun getProductById(@Path("productId") productId: Int): Response<AllProductItem>

}