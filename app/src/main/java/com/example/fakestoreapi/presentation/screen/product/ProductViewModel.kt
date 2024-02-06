package com.example.fakestoreapi.presentation.screen.product

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.fakestoreapi.domain.use_case.ProductsUseCases
import com.example.fakestoreapi.utills.UiStateObject
import com.example.fakestoreapi.utills.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsUseCases: ProductsUseCases,
    savedStateHandle: SavedStateHandle,
): BaseViewModel<ProductViewState, ProductEvent>() {

    init {
        savedStateHandle.get<String>("characterDetail")?.let {
            setState { currentState.copy(productId = it.toInt()) }
        } ?: kotlin.run {
            setEvent(ProductEvent.SnackBarError("Something went wrong"))
        }
        getProduct(uiState.value.productId)
        errorSneck()
    }

    fun getProduct(productId:Int) {
        productsUseCases.getProductUseCase.invoke(productId).onEach { result ->
            when (result) {
                is UiStateObject.SUCCESS -> {
                    setState { currentState.copy(isLoading = false, product = result.data)}
                }
                is UiStateObject.ERROR -> {
                    setState { currentState.copy(isLoading = false, error = result.message)}
                }
                is UiStateObject.LOADING -> {
                    setState { currentState.copy(isLoading = true) }
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun errorSneck() {
        viewModelScope.launch {
            delay(2000)

            setState { currentState.copy(isLoading = false, error = "Salom") }
        }
    }

    override fun createInitialState(): ProductViewState = ProductViewState()

    override fun onTriggerEvent(event: ProductEvent) {

    }

}