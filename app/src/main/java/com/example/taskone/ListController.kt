package com.example.taskone

import retrofit2.http.GET

interface RetrofitAPI {
    @GET("a29529d358a6db9d68ef")
    suspend fun getSetting(): List<ListSetting>

}
