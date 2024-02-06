package com.example.fakestoreapi.domain.repository

import com.example.fakestoreapi.data.db.model.ProductCart
import com.example.fakestoreapi.utills.UiStateList
import com.example.fakestoreapi.utills.UiStateObject
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getCartProducts(): Flow<UiStateList<ProductCart>>

    fun insertProducts(productCart: ProductCart):Flow<UiStateObject<Unit>>

    fun removeItem(id: Int):Flow<UiStateObject<Unit>>

}