package com.arifahmadalfian.weatherapp.presentation

import com.arifahmadalfian.weatherapp.domain.weather.WeatherInfo

data class WeatherState<T> (
    val isLoading: Boolean = false,
    val weather: T? = null,
    val error: String? = null
)
