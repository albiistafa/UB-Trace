package com.example.ubtrace.presentation.SignInScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ubtrace.domain.auth.AuthState
import com.example.ubtrace.domain.auth.AuthViewModel
import com.example.ubtrace.presentation.SignInScreen.Components.Loading
import com.example.ubtrace.presentation.SignInScreen.Components.Signincard
import com.example.ubtrace.presentation.SignInScreen.Components.topAppbarSign


@Composable
internal fun SignInScreen(
    navController: NavController,
    viewModel: AuthViewModel = AuthViewModel(),
    onSignUpSuccess: () -> Unit
) {
    // Collect the auth state from the ViewModel
    val state by viewModel.authState.collectAsState()

    // Handle state changes
    when (state) {
        is AuthState.Idle -> {
            SignInContent(
                state = SignInViewState(),
                onSignUp = { email, password, username ->
                    viewModel.register(email, password, username)
                }
            )
        }
        is AuthState.Loading -> {
            Loading(isLoading = true)
        }
        is AuthState.Success -> {
            onSignUpSuccess()
            navController.navigate("home") {
                popUpTo("signup") { inclusive = true }
            }
        }
        is AuthState.Error -> {
            val errorMessage = (state as AuthState.Error).errorMessage
            SignInContent(
                state = SignInViewState(isError = true, errorMessage = errorMessage),
                onSignUp = { email, password, username ->
                    viewModel.register(email, password, username)
                }
            )
        }
    }
}

@Composable
fun SignInContent(
    state: SignInViewState,
    onSignUp: (String, String, String) -> Unit
){
    Loading(isLoading = state.isLoading)

    Scaffold (
        containerColor = Color(0xFF314D51),
        modifier = Modifier.fillMaxSize(),
        topBar = {
            topAppbarSign()
        }, content = {paddingValues ->
            Column (
                modifier = Modifier.padding(paddingValues)
                    .fillMaxWidth()
            ){
                Signincard(modifier = Modifier,
                    onSignUp = onSignUp
                )
            }
        }
    )
}

@Composable
@Preview
fun preview(){
    SignInContent(state = SignInViewState(),
        onSignUp = { _, _, _ -> }
    )
}