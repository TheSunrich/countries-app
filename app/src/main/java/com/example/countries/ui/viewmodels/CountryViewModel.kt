package com.example.countries.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.model.Country
import com.example.countries.repositories.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class CountryUiState {
    object Loading : CountryUiState()
    data class Success(val countries: List<Country>) : CountryUiState()
    data class Error(val message: String) : CountryUiState()
}

class CountryViewModel(private val repository: CountryRepository = CountryRepository()) :
    ViewModel() {
    private var _uiState = MutableStateFlow<CountryUiState>(CountryUiState.Loading)
    val uiState: StateFlow<CountryUiState> = _uiState

     fun fetchCountries() {
        viewModelScope.launch {
            try {
                _uiState.value = CountryUiState.Loading
                val countries = repository.getCountries()
                _uiState.value = CountryUiState.Success(countries)

            } catch (e: Exception) {
                _uiState.value = CountryUiState.Error("An error occurred")
            }
        }
    }

    fun addCountry(country: Country) {
        viewModelScope.launch {
            try {
                _uiState.value = CountryUiState.Loading
                val newCountry = repository.addCountry(country)
                val countries = (uiState.value as CountryUiState.Success).countries.toMutableList()
                countries.add(newCountry)
                _uiState.value = CountryUiState.Success(countries)

            } catch (e: Exception) {
                _uiState.value = CountryUiState.Error("An error occurred")
            }
        }
    }


}