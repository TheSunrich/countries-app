package com.example.countries.repositories

import com.example.countries.datasources.RetrofitInstance
import com.example.countries.model.Country

class CountryRepository {
    private var api = RetrofitInstance.api

    suspend fun getCountries(): List<Country>{
        val result = api.getAllCountries()
        return result
    }

    suspend fun addCountry(country: Country): Country {
        val result = api.addCountry(country)
        return result
    }
}