package com.example.ubtrace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ubtrace.presentation.Homepage.HomeScreen
import com.example.ubtrace.presentation.LoginScreen.LoginScreen
import com.example.ubtrace.presentation.SignInScreen.SignInScreen
import com.example.ubtrace.presentation.WelcomeScreen.WelcomeScreen
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
@HiltAndroidApp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Firebase untuk cek current user
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser

    // Tentukan startDestination berdasarkan apakah ada current user
    NavHost(
        navController = navController,
        startDestination = if (currentUser != null) "home" else "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            // Pass the onLoginSuccess parameter here
            LoginScreen(navController) {
                // This will be executed after a successful login
                navController.navigate("home")
            }
        }
        composable("signup") {
            SignInScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}