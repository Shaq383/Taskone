package com.example.taskone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskone.screens.Home
import com.example.taskone.screens.Profile
import com.example.taskone.screens.Setting


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                ScreenMain()
            }
        }
    }
}

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            Home(navController = navController)
        }
        composable("${Routes.Profile.route}?name={name}&age={age}") {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getString("age")
            Profile(name = name, age = age)
        }
        composable(Routes.Settings.route) {
            Setting()
        }
    }
}
