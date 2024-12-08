package com.example.ubtrace.presentation.LoginScreen

data class LoginViewState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)