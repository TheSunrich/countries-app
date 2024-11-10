package com.example.countries.datasources

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://countries-api-ffbtcjemdbexcsgq.canadacentral-01.azurewebsites.net/"

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    val api: CountryApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CountryApiService::class.java)
    }
}