package com.arifahmadalfian.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,preasure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
    )
}