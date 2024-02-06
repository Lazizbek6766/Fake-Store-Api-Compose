package com.example.fakestoreapi.data.repository

import com.example.fakestoreapi.data.db.ProductCartDao
import com.example.fakestoreapi.data.db.model.ProductCart
import com.example.fakestoreapi.domain.repository.CartRepository
import com.example.fakestoreapi.utills.UiStateList
import com.example.fakestoreapi.utills.UiStateObject
import com.example.fakestoreapi.utills.extentions.userMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CartRepositoryImpl(private val productCartDao: ProductCartDao): CartRepository {
    override fun getCartProducts(): Flow<UiStateList<ProductCart>> = flow {
        emit(UiStateList.LOADING)
        try {
            val response = productCartDao.getCartProducts()
            emit(UiStateList.SUCCESS(response))
        } catch (e: Exception) {
            emit(UiStateList.ERROR(e.localizedMessage ?: e.userMessage()))
        }
    }

    override fun insertProducts(productCart: ProductCart): Flow<UiStateObject<Unit>> = flow {
        emit(UiStateObject.LOADING)
        try {
            val response = productCartDao.insertProducts(productCart)
            emit(UiStateObject.SUCCESS(response))
        } catch (e: Exception) {
            emit(UiStateObject.ERROR(e.localizedMessage ?: e.userMessage()))
        }
    }

    override fun removeItem(id: Int): Flow<UiStateObject<Unit>> = flow {
        emit(UiStateObject.LOADING)
        try {
            val response = productCartDao.removeProductItem(id)
            emit(UiStateObject.SUCCESS(response))
        } catch (e: Exception) {
            emit(UiStateObject.ERROR(e.localizedMessage ?: e.userMessage()))
        }
    }
}