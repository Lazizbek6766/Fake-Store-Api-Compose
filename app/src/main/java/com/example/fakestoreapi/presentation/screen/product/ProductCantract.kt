package com.example.fakestoreapi.presentation.screen.product

import androidx.compose.runtime.Stable
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.viewstate.IViewEvent
import com.example.fakestoreapi.domain.viewstate.IViewState

@Stable
data class ProductViewState(
    val isLoading:Boolean = false,
    val product:AllProductItem? = null,
    val productId:Int = 1,
    val error:String = "",
): IViewState

sealed class ProductEvent() : IViewEvent {
    class SnackBarError(val message: String?) : ProductEvent()
}