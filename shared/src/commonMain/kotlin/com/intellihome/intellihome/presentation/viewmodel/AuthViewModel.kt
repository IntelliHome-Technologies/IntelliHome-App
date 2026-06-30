package com.intellihome.intellihome.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.intellihome.intellihome.data.entity.Device
import com.intellihome.intellihome.data.repository.Repository
import com.intellihome.intellihome.presentation.model.AuthState
import com.intellihome.intellihome.presentation.model.HomeState
import com.intellihome.intellihome.presentation.model.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    fun onEmailChange(email: String) {
        _state.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _state.update { it.copy(password = password) }
    }

    fun login() {
        if (_state.value.email.isBlank() || _state.value.password.isBlank()) {
            _state.update { it.copy(error="Email and password required")}
            return
        }
        _state.update { it.copy(error="")}

    }

    fun clear() = viewModelScope.cancel()
}