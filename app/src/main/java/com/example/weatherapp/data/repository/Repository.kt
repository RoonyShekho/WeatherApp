package com.example.weatherapp.data.repository

import com.example.weatherapp.data.database.WeatherDao
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.model.Weather
import javax.inject.Inject

class Repository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) {
    suspend fun getWeatherInfo(latLon:String, apiKey :String):Weather{
        return weatherApi.getWeatherInfo(country = latLon, apiKey = apiKey)
    }


    suspend fun getWeatherFromDatabase():Weather{
        return weatherDao.getWeatherFromDatabase()
    }


    suspend fun deleteAllItems(){
        weatherDao.deleteAllItems()
    }

    suspend fun saveWeather(weather:Weather){
        weatherDao.saveWeather(weather)
    }
}