package com.arifahmadalfian.weatherapp.presentation

import com.arifahmadalfian.weatherapp.domain.weather.WeatherInfo

data class WeatherState (
    val isLoading: Boolean = false,
    val weather: WeatherInfo? = null,
    val error: String? = null
)
