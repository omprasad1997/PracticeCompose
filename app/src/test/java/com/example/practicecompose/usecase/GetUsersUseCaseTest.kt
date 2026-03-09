package com.example.practicecompose.usecase

import com.example.practicecompose.domain.usecase.GetUsersUseCase
import com.example.practicecompose.fake.FakeUserRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetUsersUseCaseTest {

    private lateinit var useCase: GetUsersUseCase
    private val repository = FakeUserRepository()

    @Before
    fun setup() {
        useCase = GetUsersUseCase(repository)
    }

    @Test
    fun `get users returns list`() = runTest {

        val result = useCase(1)

        assertEquals(2, result.size)
    }
}