package com.arifahmadalfian.weatherapp.data.repository

import com.arifahmadalfian.weatherapp.data.mappers.toWeatherInfo
import com.arifahmadalfian.weatherapp.data.remote.IWeatherApi
import com.arifahmadalfian.weatherapp.domain.repository.IWeatherRepository
import com.arifahmadalfian.weatherapp.domain.util.Resource
import com.arifahmadalfian.weatherapp.domain.weather.WeatherInfo

class WeatherRepository(
    private val api: IWeatherApi
): IWeatherRepository {

    override suspend fun getWeatherData(lat: Double, lon: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    lon = lon
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown Error Occurred!")
        }
    }
}