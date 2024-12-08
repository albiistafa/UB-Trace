package com.example.ubtrace.presentation.SignInScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ubtrace.presentation.LoginScreen.Components.Logincard
import com.example.ubtrace.presentation.LoginScreen.Components.topAppbarLogSign
import com.example.ubtrace.presentation.SignInScreen.Components.Loading
import com.example.ubtrace.presentation.SignInScreen.Components.Signincard
import com.example.ubtrace.presentation.SignInScreen.Components.topAppbarSign


@Composable
internal fun SignInScreen(
    navController: NavController
){

}

@Composable
fun SignInContent(
    state: SignInViewState
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
                Signincard(modifier = Modifier
                )
            }
        }
    )
}

@Composable
@Preview
fun preview(){
    SignInContent(state = SignInViewState())
}