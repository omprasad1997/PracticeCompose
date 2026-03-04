package com.example.practicecompose.domain.usecase

import com.example.practicecompose.domain.model.User
import com.example.practicecompose.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(page: Int): List<User> {

        return repository.getUsers(page)

    }
}