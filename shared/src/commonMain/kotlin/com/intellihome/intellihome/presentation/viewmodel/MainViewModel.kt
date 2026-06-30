package com.intellihome.intellihome.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.intellihome.intellihome.data.repository.Repository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.intellihome.intellihome.presentation.model.UiState

class MainViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()

    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            try {
                val data = repository.getAllPosts()
                _state.value = UiState(posts = data)
            } catch (e: Exception) {
                _state.value = UiState(error = e.message)
            }
        }
    }

    fun clear() {
        viewModelScope.cancel()
    }
}
