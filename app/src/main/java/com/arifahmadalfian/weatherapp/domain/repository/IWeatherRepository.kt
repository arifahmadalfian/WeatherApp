package com.arifahmadalfian.weatherapp.domain.repository

import com.arifahmadalfian.weatherapp.domain.util.Resource
import com.arifahmadalfian.weatherapp.domain.weather.WeatherInfo

interface IWeatherRepository {
    suspend fun getWeatherData(lat: Double, lon: Double): Resource<WeatherInfo>
}