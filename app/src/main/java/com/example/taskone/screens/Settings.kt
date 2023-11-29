package com.example.taskone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.taskone.RetrofitAPI

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setting() {
    var search by remember { mutableStateOf("") }
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
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color(0xFFF7FAFF),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(25.dp)
            )
            Text(
                text = "Settings",
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
        ){
            TextField(
                value = search,
                onValueChange = { search = it},
                label = { Text("Search Setting") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Color.Black,
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
                leadingIcon =
                {
                    Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF494949),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .size(25.dp)
                )},
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            DisplayListView()
        }
    }
}

@Composable
fun DisplayListView() {
    var courseList by remember { mutableStateOf<List<String>>(emptyList()) }
    var isError by remember { mutableStateOf(false) }
    val retrofit = remember {
        Retrofit.Builder()
            .baseUrl("https://api.npoint.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

    LaunchedEffect(Unit) {
        try {
            val setting = retrofitAPI.getSetting()
            courseList = setting.map { it.settingName }
        } catch (e: Exception) {
            isError = true
        }
    }

    if (isError) {
        Snackbar(
            action = {
                TextButton(onClick = { isError = false }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color(0xFFD7DFF0),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(25.dp)
                    )
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .background(
                    color = Color(0xFF26282B),
                    shape = RoundedCornerShape(5.dp)
                ),
        ) {
            Text(
                text = "Failed to get data, No internet connection available",
                color = Color(0xFFF7FAFF),
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                ),
        ) {
            items(courseList) { setting ->
                Text(
                    setting,
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    color = Color(0xFF494949),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W400
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    thickness = 1.dp,
                    color = Color(0x1D000000)
                )
            }
        }
    }
}