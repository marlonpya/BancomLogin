package com.example.bancomlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bancomlogin.home.HomeScreen
import com.example.bancomlogin.login.LoginScreen
import com.example.bancomlogin.login.LoginViewModel
import com.example.bancomlogin.ui.theme.BancomLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BancomLoginTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Destination.LOGIN) {
                    composable(Destination.LOGIN) {
                        LoginScreen(navController = navController, viewModel = LoginViewModel())
                    }
                    composable(Destination.HOME) {
                        HomeScreen()
                    }
                }
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //LoginScreen(viewModel = LoginViewModel())
                    HomeScreen()
                }*/
            }
        }
    }
}