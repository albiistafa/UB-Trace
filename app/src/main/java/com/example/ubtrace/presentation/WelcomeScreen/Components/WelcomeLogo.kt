package com.example.ubtrace.presentation.WelcomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ubtrace.R

@Composable
fun welcomelogo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.welcomelogo),
        contentDescription = "Logo",
        modifier = Modifier.size(350.dp))
}