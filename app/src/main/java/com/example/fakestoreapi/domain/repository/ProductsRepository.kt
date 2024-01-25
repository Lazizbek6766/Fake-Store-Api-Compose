package com.example.fakestoreapi.domain.repository

import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.utills.UiStateList
import com.example.fakestoreapi.utills.UiStateObject
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<UiStateList<AllProductItem>>

    fun getCategories(): Flow<UiStateList<String>>

    fun getProductById(productId: Int): Flow<UiStateObject<AllProductItem>>

}