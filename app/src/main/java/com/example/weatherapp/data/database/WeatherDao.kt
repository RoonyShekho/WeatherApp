package com.example.weatherapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.domain.model.Weather


@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_table")
    suspend fun getWeatherFromDatabase(): Weather

    @Query("DELETE FROM weather_table")
    suspend fun deleteAllItems()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveWeather(weather:Weather)

}