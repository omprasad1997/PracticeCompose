package com.example.practicecompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicecompose.domain.model.User
import com.example.practicecompose.domain.usecase.GetUsersUseCase
import com.example.practicecompose.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val useCase: GetUsersUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<ResultState<List<User>>>(ResultState.Loading)

    val state: StateFlow<ResultState<List<User>>> = _state

    init {
        loadUsers()
    }

    fun loadUsers() {

        viewModelScope.launch {

            try {

                val users = useCase(1)

                _state.value =
                    ResultState.Success(users)

            } catch (e: Exception) {

                _state.value =
                    ResultState.Error(e.message ?: "Error")

            }

        }
    }
}