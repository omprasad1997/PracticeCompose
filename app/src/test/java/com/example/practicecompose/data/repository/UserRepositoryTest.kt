package com.example.practicecompose.data.repository

import com.example.practicecompose.data.remote.UserApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test

class UserRepositoryTest {

    @Test
    fun `getUsers returns correct list`() = runTest {

        val mockEngine = MockEngine { request ->

            respond(
                content = """
                    [
                      {"id":1,"name":"John","email":"john@test.com"}
                    ]
                """,
                headers = headersOf(
                    HttpHeaders.ContentType,
                    "application/json"
                )
            )
        }

        val client = HttpClient(mockEngine) {

            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }

        }

        val api = UserApi(client)

        val repository = UserRepositoryImpl(api)

        val users = repository.getUsers(1)

        assertEquals(1, users.size)
        assertEquals("John", users[0].name)
    }
}