package com.intellihome.intellihome.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Post (
    val id: Int,
    val title: String,
    val body: String,
)
