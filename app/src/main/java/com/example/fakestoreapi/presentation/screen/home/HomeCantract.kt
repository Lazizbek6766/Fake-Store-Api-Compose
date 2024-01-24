package com.example.fakestoreapi.presentation.screen.home

import androidx.compose.runtime.Stable
import com.example.fakestoreapi.domain.model.AllProductItem
import com.example.fakestoreapi.domain.viewstate.IViewEvent
import com.example.fakestoreapi.domain.viewstate.IViewState

@Stable
data class ViewState(
    val isLoading:Boolean = false,
    val products:List<AllProductItem> = emptyList(),
    val categories:List<String> = emptyList(),
    val error:String = "",
): IViewState

sealed class ForYouEvent() : IViewEvent {
    data class EventSelectedChange(val selected: String) : ForYouEvent()
}