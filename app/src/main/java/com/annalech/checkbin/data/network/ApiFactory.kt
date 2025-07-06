package com.annalech.checkbin.data.network


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


object ApiFactory {
    private const val BASE_URL = "https://lookup.binlist.net/"

    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val contentType = "application/json".toMediaType()


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()


    val apiService = retrofit.create(ApiService::class.java)
}