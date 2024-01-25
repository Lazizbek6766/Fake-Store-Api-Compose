package com.example.fakestoreapi.domain.use_case

import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.repository.ProductsRepository
import com.example.fakestoreapi.utills.UiStateObject
import kotlinx.coroutines.flow.Flow

class GetProductUseCase (
    private val repository: ProductsRepository
) {
    operator fun invoke(productId:Int): Flow<UiStateObject<AllProductItem>> = repository.getProductById(productId)
}