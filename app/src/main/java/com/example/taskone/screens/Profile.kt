package com.example.taskone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.*

@Composable
fun Profile(name: String?, age: String?) {
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
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                tint = Color(0xFFF7FFE5),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Profile",
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
            Text(
                text = "This is Profile Page",
                Modifier.padding(10.dp),
                color = Color(0xFF262B26),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
            Text(
                text = "Your name is $name",
                Modifier.padding(10.dp),
                color = Color(0xFF262B26),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
            Text(
                text = "Your age is $age",
                Modifier.padding(10.dp),
                color = Color(0xFF262B26),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
        }
    }
}
