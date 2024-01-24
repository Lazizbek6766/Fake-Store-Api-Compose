package com.example.fakestoreapi.data.remote

import com.example.fakestoreapi.domain.model.AllProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): Response<List<AllProductItem>>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>
}