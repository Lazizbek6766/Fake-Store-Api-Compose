package com.example.fakestoreapi.data.repository

import com.example.fakestoreapi.data.remote.ApiService
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.repository.ProductsRepository
import com.example.fakestoreapi.utills.UiStateList
import com.example.fakestoreapi.utills.extentions.userMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsRepositoryImpl(private val apiService: ApiService):ProductsRepository {

    override fun getProducts(): Flow<UiStateList<AllProductItem>> = flow {
        emit(UiStateList.LOADING)
        try {
            val response = apiService.getProducts()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    emit(UiStateList.SUCCESS(responseBody))
                } else {
                    emit(UiStateList.ERROR("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.toString() ?: "Unknown error"
                emit(UiStateList.ERROR(errorBody))
            }
        } catch (e: Exception) {
            emit(UiStateList.ERROR(e.userMessage()))
        }
    }

    override fun getCategories(): Flow<UiStateList<String>> = flow {
        emit(UiStateList.LOADING)
        try {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    emit(UiStateList.SUCCESS(responseBody))
                } else {
                    emit(UiStateList.ERROR("Response body is null"))
                }
            } else {
                val errorBody = response.errorBody()?.toString() ?: "Unknown error"
                emit(UiStateList.ERROR(errorBody))
            }

        } catch (e: Exception) {
            emit(UiStateList.ERROR(e.userMessage()))
        }
    }

}