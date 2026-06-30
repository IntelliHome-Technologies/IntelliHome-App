package com.intellihome.intellihome.data.repository

import com.intellihome.intellihome.data.network.ApiService
import com.intellihome.intellihome.data.entity.Post

class Repository(private val api: ApiService) {
    suspend fun getAllPosts(): List<Post> = api.getPosts()
}
