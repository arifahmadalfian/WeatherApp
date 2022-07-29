package com.arifahmadalfian.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifahmadalfian.weatherapp.domain.location.ILocationTracker
import com.arifahmadalfian.weatherapp.domain.repository.IWeatherRepository
import com.arifahmadalfian.weatherapp.domain.util.Resource
import com.arifahmadalfian.weatherapp.domain.weather.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: IWeatherRepository,
    private val locationTracker: ILocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState<WeatherInfo>())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                state = when (val result = repository.getWeatherData(location.latitude, location.longitude)) {
                    is Resource.Error -> {
                        state.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Success -> {
                        state.copy(
                            isLoading = false,
                            weather = result.data,
                            error = null
                        )
                    }
                }
            } ?: run {
                state = state.copy(
                    isLoading = false,
                    error = "Location not found"
                )
            }
        }
    }


}