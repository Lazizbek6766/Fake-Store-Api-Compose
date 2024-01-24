package com.example.fakestoreapi.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.example.fakestoreapi.domain.use_case.ProductsUseCases
import com.example.fakestoreapi.utills.UiStateList
import com.example.fakestoreapi.utills.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsUseCases: ProductsUseCases
): BaseViewModel<ViewState, ForYouEvent>() {

    private val _selectedCategory = MutableStateFlow<String>("")
    val selectedCategory = _selectedCategory.asStateFlow()

    init {
        getAllProducts()
        getAllCategoryes()
    }

    fun getAllProducts() {
        productsUseCases.getAllProductsUseCase.invoke().onEach { result ->
            when (result) {
                is UiStateList.SUCCESS -> {
                    setState { currentState.copy(isLoading = false, products = result.data)}
                }
                is UiStateList.ERROR -> {
                    setState { currentState.copy(isLoading = false, error = result.message)}
                }
                is UiStateList.LOADING -> {
                    setState { currentState.copy(isLoading = true) }
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun getAllCategoryes() {
        productsUseCases.getAllCategoryUseCase.invoke().onEach { result ->
            when (result) {
                is UiStateList.SUCCESS -> {
                    setState { currentState.copy(isLoading = false, categories = result.data)}
                    _selectedCategory.value = result.data[0]
                }
                is UiStateList.ERROR -> {
                    setState { currentState.copy(isLoading = false, error = result.message)}
                }
                is UiStateList.LOADING -> {
                    setState { currentState.copy(isLoading = true) }
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    override fun onTriggerEvent(event: ForYouEvent) {
        when (event) {
            is ForYouEvent.EventSelectedChange -> _selectedCategory.value = event.selected

        }
    }

    override fun createInitialState(): ViewState = ViewState()
}