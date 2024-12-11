package com.example.ubtrace.presentation.ProfilScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ubtrace.domain.auth.AuthViewModel
import com.example.ubtrace.presentation.LoginScreen.Components.Logincard
import com.example.ubtrace.presentation.components.ProfileCard
import com.example.ubtrace.presentation.util.components.Bottombar
import com.example.ubtrace.presentation.util.components.topAppbar

@Composable
internal fun profilScreen(
    navController: NavController,
    viewModel: AuthViewModel = AuthViewModel(),
){
    
}

@Composable
fun profilContent(
    modifier: Modifier = Modifier
    ) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { topAppbar("Profil Saya") },
        content = { paddingValues ->
            Column (
                    modifier = Modifier.padding(paddingValues)
                        .fillMaxWidth()
                    ){
                ProfileCard(
                    name = "Arifal Aghna",
                    email = "arifalaghna@gmail.com",
                    numberPhone = "082254676543"
                ) {

                }
            }
        },
        bottomBar = {Bottombar()}
    )
}

@Composable
@Preview
fun priview(){
    profilContent()
}