package com.example.fakestoreapi.domain.use_case

import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.repository.ProductsRepository
import com.example.fakestoreapi.utills.UiStateList
import kotlinx.coroutines.flow.Flow

class GetAllCategoryUseCase (
    private val repository: ProductsRepository
) {
    operator fun invoke(): Flow<UiStateList<String>> = repository.getCategories()

}