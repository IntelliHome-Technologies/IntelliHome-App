package com.intellihome.intellihome.presentation.model

data class AuthState(
    val email: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val error: String? = null
)
