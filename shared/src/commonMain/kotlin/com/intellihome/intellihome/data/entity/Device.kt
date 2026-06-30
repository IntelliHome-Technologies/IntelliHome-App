package com.intellihome.intellihome.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Device (
    val id: String,
    val name: String,

)