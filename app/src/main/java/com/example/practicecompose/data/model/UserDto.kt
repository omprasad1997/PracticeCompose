package com.example.practicecompose.data.model

import com.example.practicecompose.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int,
    val name: String,
    val email: String
)

fun UserDto.toDomain(): User {
    return User(id, name, email)
}