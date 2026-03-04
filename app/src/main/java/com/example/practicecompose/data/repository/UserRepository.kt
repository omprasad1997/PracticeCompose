package com.example.practicecompose.data.repository

import com.example.practicecompose.data.api.UserApi

class UserRepository {

    private val api = UserApi()

    suspend fun getUsers() = api.getUsers()

}