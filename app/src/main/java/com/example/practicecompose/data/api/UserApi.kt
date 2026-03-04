package com.example.practicecompose.data.api

import com.example.practicecompose.data.model.User
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserApi {

    suspend fun getUsers(): List<User> {
        return ApiClient.client
            .get("https://jsonplaceholder.typicode.com/users")
            .body()
    }
}