package com.example.ubtrace.presentation.SignInScreen

data class SignInViewState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)