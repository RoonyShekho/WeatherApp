package com.example.weatherapp.data.remote

import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/forecast.json")
     suspend fun getWeatherInfo(
        @Query("key") apiKey:String = API_KEY,
        @Query("q") country:String = "36.191,44,0091"
    ):Weather
}