package com.example.ubtrace.presentation.WelcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ubtrace.R
import com.example.ubtrace.presentation.Homepage.HomeContent
import com.example.ubtrace.presentation.Homepage.HomeViewState
import com.example.ubtrace.presentation.WelcomeScreen.Components.Loading
import com.example.ubtrace.presentation.WelcomeScreen.Components.buttonDaftar
import com.example.ubtrace.presentation.WelcomeScreen.Components.buttonMasuk
import com.example.ubtrace.presentation.WelcomeScreen.Components.welcomelogo

@Composable
internal fun WelcomeScreen(navController: NavController){
    val state by remember { mutableStateOf(WelcomeViewState(isLoading = true)) }

    WelcomeContent(
        state = state,
        navController = navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeContent(
    state: WelcomeViewState,
    navController: NavController
){
    Loading(isLoading = state.isLoading)

    Scaffold (
        topBar = {
            TopAppBar(title = { Text("") })
        }, content = { paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(46.dp))

                welcomelogo()

                Spacer(modifier = Modifier.height(210.dp))

                buttonMasuk(
                    { navController.navigate("login") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                buttonDaftar({ navController.navigate("signup") })

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    )
}

@Composable
@Preview
fun preview(){
    val navController = rememberNavController()
    WelcomeContent(
        state = WelcomeViewState(),
        navController = navController
    )
}