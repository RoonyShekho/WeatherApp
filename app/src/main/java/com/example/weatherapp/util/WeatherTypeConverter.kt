package com.example.weatherapp.util

import androidx.room.TypeConverter
import com.example.weatherapp.domain.model.Current
import com.example.weatherapp.domain.model.Forecast
import com.example.weatherapp.domain.model.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class WeatherTypeConverter{

    @TypeConverter
    fun toCurrentJson(current: Current): String {
        return Gson().toJson(
            current,
            object : TypeToken<Current>() {}.type
        ) ?: "[]"
    }


    @TypeConverter
    fun fromCurrentJson(json: String): Current {
        return Gson().fromJson<Current>(
            json,
            object : TypeToken<Current>() {}.type
        ) ?: Current()
    }


    @TypeConverter
    fun toForecastJson(forecast: Forecast): String {
        return Gson().toJson(forecast, object : TypeToken<Forecast>() {}.type)
    }


    @TypeConverter
    fun fromForecastJson(json: String): Forecast {
        return Gson().fromJson<Forecast>(
            json,
            object : TypeToken<Forecast>() {}.type
        ) ?: Forecast()
    }


    @TypeConverter
    fun toLocationJson(location: Location): String {
        return Gson().toJson(location, object : TypeToken<Location>() {}.type)
    }


    @TypeConverter
    fun fromLocation(json: String): Location {
        return Gson().fromJson<Location>(
            json,
            object : TypeToken<Location>() {}.type
        ) ?: Location()
    }
}