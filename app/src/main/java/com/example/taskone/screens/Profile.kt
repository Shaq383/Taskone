package com.example.taskone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*

@SuppressLint("InvalidColorHexValue")
@Composable
fun Profile(name: String?, age: String?) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFF7FAFF), Color(0xFFD7DFF0)),
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
                .background(color = Color(0xFF26282B))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                tint = Color(0xFFF7FAFF),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Profile",
                color = Color(0xFFF7FAFF),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile",
                tint = Color(0x7A000000),
                modifier = Modifier
                    .size(200.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color(0xFF494949),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(30.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Name",
                        Modifier.padding(top = 5.dp),
                        color = Color(0x74494949),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text = "$name",
                        Modifier.padding(vertical = 5.dp),
                        color = Color(0xFF494949),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W400
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Profile",
                    tint = Color(0xFF494949),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(30.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Age",
                        Modifier.padding(top = 5.dp),
                        color = Color(0x74494949),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text = "$age",
                        Modifier.padding(vertical = 5.dp),
                        color = Color(0xFF494949),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }
    }
}
