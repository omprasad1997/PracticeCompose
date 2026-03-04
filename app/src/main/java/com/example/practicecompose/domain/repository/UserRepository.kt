package com.example.practicecompose.domain.repository

import com.example.practicecompose.domain.model.User

interface UserRepository {

    suspend fun getUsers(page: Int): List<User>

}