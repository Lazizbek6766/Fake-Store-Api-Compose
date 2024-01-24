package com.example.fakestoreapi.utills.base

import androidx.lifecycle.ViewModel
import com.example.fakestoreapi.domain.viewstate.IViewEvent
import com.example.fakestoreapi.domain.viewstate.IViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<State : IViewState, Event : IViewEvent> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }

    abstract fun createInitialState(): State

    val currentState: State get() = uiState.value

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState: StateFlow<State> = _uiState

    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }
    abstract fun onTriggerEvent(event:Event)

}