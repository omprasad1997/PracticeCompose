package com.example.practicecompose.viewmodel

import com.example.practicecompose.domain.usecase.GetUsersUseCase
import com.example.practicecompose.fake.FakeUserRepository
import com.example.practicecompose.presentation.viewmodel.UserViewModel
import com.example.practicecompose.utils.ResultState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private lateinit var viewModel: UserViewModel
    private val repository = FakeUserRepository()

    @Before
    fun setup() {
        val useCase = GetUsersUseCase(repository)
        viewModel = UserViewModel(useCase)
    }

    @Test
    fun `loadUsers emits success state`() = runTest {

        viewModel.loadUsers()

        val state = viewModel.state.value

        assertTrue(state is ResultState.Success)
    }
}