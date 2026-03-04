package com.example.practicecompose.data.repository

import com.example.practicecompose.data.model.toDomain
import com.example.practicecompose.data.remote.UserApi
import com.example.practicecompose.domain.model.User
import com.example.practicecompose.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    override suspend fun getUsers(page: Int): List<User> {

        return api.getUsers(page).map {
            it.toDomain()
        }

    }
}