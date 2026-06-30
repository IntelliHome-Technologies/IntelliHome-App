package com.intellihome.intellihome.presentation.model

import com.intellihome.intellihome.data.entity.Post

data class UiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)
