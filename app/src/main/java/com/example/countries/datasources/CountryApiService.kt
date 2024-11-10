package com.example.countries.datasources

import com.example.countries.model.Country
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CountryApiService {
    @GET("countries")
    suspend fun getAllCountries(): List<Country>

    @POST("countries")
    suspend fun addCountry(@Body country: Country): Country
}