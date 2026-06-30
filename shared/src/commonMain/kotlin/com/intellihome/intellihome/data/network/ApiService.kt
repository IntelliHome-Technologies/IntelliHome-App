package com.intellihome.intellihome.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import com.intellihome.intellihome.data.entity.Post


class ApiService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getPosts(): List<Post> =
        client.get("https://jsonplaceholder.typicode.com/posts").body()
}
