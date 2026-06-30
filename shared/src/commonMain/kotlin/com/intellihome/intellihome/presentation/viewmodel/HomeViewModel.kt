package com.intellihome.intellihome.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.intellihome.intellihome.data.entity.Device
import com.intellihome.intellihome.data.repository.Repository
import com.intellihome.intellihome.presentation.model.HomeState
import com.intellihome.intellihome.presentation.model.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadDevices()
    }

    fun loadDevices() {
        val devices: List<Device> = listOf(
            Device(id="1", name="Device 1"),
            Device(id="2", name="Device 2"),
            Device(id="3", name="Device 3"),
        )
        _state.value = HomeState(isLoading = false, devices = devices)
    }

    fun clear() = viewModelScope.cancel()
}