package com.example.weatherapp.screen.home

import com.example.weatherapp.domain.model.Weather

data class WeatherState(
    val weather:Weather = Weather(),
    val isPermissionGranted:Boolean = false
)