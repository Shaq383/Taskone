package com.example.taskone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.taskone.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    var age by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFF7FFE5), Color(0xFFCEDEBD)),
        startY = 0f,
        endY = 1000f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF262B26))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color(0xFFF7FFE5),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Home",
                color = Color(0xFFF7FFE5),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name,
                onValueChange = { newName -> name = newName },
                label = { Text("Enter your name") },
                textStyle = TextStyle(color = Color(0xFF262B26)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)

            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(color = Color(0xFFE4E2E9)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Enter your age $age",
                    color = Color(0xFF262B26),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                )

                Button(
                    onClick = { age++ },
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 5.dp)
                        .background(
                            color = Color(0xFF657561), // Background color
                            shape = RoundedCornerShape(6.dp) // Corner radius
                        )
                        .height(40.dp), // Set the button height
                    colors = ButtonDefaults.buttonColors(Color(0xFF657561)),
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp, pressedElevation = 4.dp))
                {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color(0xFFF7FFE5),
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { navController.navigate("${Routes.Profile.route}?name=${name}&age=${age}") },
                content = {
                    Text("Navigate to Profile", color = Color(0xFFF7FFE5))
                },
                modifier = Modifier
                    .background(
                        color = Color(0xFF657561), // Background color
                        shape = RoundedCornerShape(6.dp) // Corner radius
                    )
                    .height(40.dp), // Set the button height
                colors = ButtonDefaults.buttonColors(Color(0xFF657561)),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp, pressedElevation = 4.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate("${Routes.Settings.route}/$age") },
                content = { Text("Navigate to Settings", color = Color(0xFFF7FFE5)) },
                modifier = Modifier
                    .background(
                        color = Color(0xFF657561), // Background color
                        shape = RoundedCornerShape(6.dp) // Corner radius
                    )
                    .height(40.dp), // Set the button height
                colors = ButtonDefaults.buttonColors(Color(0xFF657561)),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp, pressedElevation = 4.dp)
            )
        }
    }
}
