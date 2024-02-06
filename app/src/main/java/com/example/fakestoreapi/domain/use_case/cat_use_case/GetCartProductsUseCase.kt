package com.example.fakestoreapi.domain.use_case.cat_use_case

import com.example.fakestoreapi.data.db.model.ProductCart
import com.example.fakestoreapi.domain.repository.CartRepository
import com.example.fakestoreapi.utills.UiStateList
import kotlinx.coroutines.flow.Flow

class GetCartProductsUseCase(
    private val repository: CartRepository
) {
    operator fun invoke(): Flow<UiStateList<ProductCart>> = repository.getCartProducts()

}