package com.intellihome.intellihome.presentation.model

import com.intellihome.intellihome.data.entity.Device

data class HomeState(
    val isLoading: Boolean = false,
    val devices: List<Device> = emptyList(),
    val error: String? = null
)
