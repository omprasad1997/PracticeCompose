package com.example.practicecompose.data.remote

import com.example.practicecompose.data.model.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class UserApi @Inject constructor(
    private val client: HttpClient
) {

    suspend fun getUsers(page: Int): List<UserDto> {

        return client.get(
            "https://jsonplaceholder.typicode.com/users"
        ).body()

    }

}