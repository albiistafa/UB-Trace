package com.example.ubtrace.presentation.ProfilScreen

data class ProfilViewState (
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)