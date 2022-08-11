package com.example.weatherapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.util.WeatherTypeConverter


@Database(
    entities = [ Weather::class ],
    version = 1
)
@TypeConverters(WeatherTypeConverter::class)
abstract class WeatherDatabase:RoomDatabase(){
    abstract val weatherDao:WeatherDao
}