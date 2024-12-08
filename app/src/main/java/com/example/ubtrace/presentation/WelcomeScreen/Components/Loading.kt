package com.example.ubtrace.presentation.WelcomeScreen.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Loading(isLoading: Boolean) {
    if (isLoading){
    CircularProgressIndicator(modifier = Modifier.padding(10.dp))
    }
}