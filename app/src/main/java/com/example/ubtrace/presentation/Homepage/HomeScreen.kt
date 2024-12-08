package com.example.ubtrace.presentation.Homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.ubtrace.presentation.Homepage.Components.Loading
import com.example.ubtrace.presentation.Homepage.Components.topAppbarHome
import com.example.ubtrace.presentation.util.components.Bottombar

@Composable
internal fun HomeScreen(navController: NavController){
    val state by remember { mutableStateOf(HomeViewState(isLoading = true)) }

    HomeContent(state = state)
}

@Composable
fun HomeContent(state: HomeViewState){
    Loading(isLoading = state.isLoading)

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            topAppbarHome(tittle = "HALAMAN")
        }, content = { paddingValues ->
            Column (
                modifier = Modifier.padding(paddingValues)
            ){

            }
        },
        bottomBar = {
            Bottombar()
        }
    )
}

@Composable
@Preview
fun preview(){
    HomeContent(state = HomeViewState())
}