package com.example.practicecompose.fake

import com.example.practicecompose.domain.model.User
import com.example.practicecompose.domain.repository.UserRepository

class FakeUserRepository : UserRepository {

    override suspend fun getUsers(page: Int): List<User> {
        return listOf(
            User(1, "John Doe", "john@test.com"),
            User(2, "Jane Doe", "jane@test.com")
        )
    }
}