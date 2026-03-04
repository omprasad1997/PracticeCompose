package com.example.practicecompose.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.practicecompose.domain.model.User
import com.example.practicecompose.presentation.viewmodel.UserViewModel
import com.example.practicecompose.utils.ResultState

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    // Trigger API call when screen loads
    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    when (state) {

        is ResultState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ResultState.Success -> {

            val users = (state as ResultState.Success<List<User>>).data

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                items(users) { user ->
                    UserItem(user)
                }

            }
        }

        is ResultState.Error -> {

            val message = (state as ResultState.Error).message

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(text = message)
            }
        }
    }
}