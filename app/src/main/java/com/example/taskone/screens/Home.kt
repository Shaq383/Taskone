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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.taskone.Routes

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    var age by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }

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
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color(0xFFF7FAFF),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Home",
                color = Color(0xFFF7FAFF),
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300
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
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedLabelColor = Color(0x52000000),
                    unfocusedLabelColor = Color(0xFF494949),
                    focusedIndicatorColor = Color(0x0),
                    unfocusedIndicatorColor = Color(0x0)
                ),
                textStyle = TextStyle(
                    color = Color(0xFF494949),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W400
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )

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
            ) {
                Text(
                    "Enter your age $age",
                    color = Color(0xFF494949),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W400,
                    letterSpacing = 0.4.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Button(
                    onClick = { age++ },
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 7.dp)
                        .height(40.dp)
                        .width(65.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFE3ECFF)),
                    content =
                    {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color(0xFF484E48),
                        modifier = Modifier
                            .size(25.dp)
                    ) },
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                thickness = 1.dp,
                color = Color(0x9FFFFFFF)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { navController.navigate("${Routes.Profile.route}?name=${name}&age=${age}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                content =
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Account",
                            tint = Color(0xFF494949),
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(22.dp)
                        )
                        Text(
                            text = "Account",
                            color = Color(0xFF494949),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.W400
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Arrow",
                            tint = Color(0xFF494949),
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(25.dp)
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate(Routes.Settings.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                content =
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color(0xFF494949),
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(22.dp)
                        )
                        Text(
                            text = "Settings",
                            color = Color(0xFF494949),
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.W400
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Arrow",
                            tint = Color(0xFF494949),
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(25.dp)
                        )
                    }
                }
            )
        }
    }
}
