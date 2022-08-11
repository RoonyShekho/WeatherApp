package com.example.weatherapp.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    tableName = "weather_table"
)
data class Weather(
    @SerialName("current")
    val current: Current = Current(),
    @SerialName("forecast")
    val forecast: Forecast = Forecast(),
    @SerialName("location")
    val location: Location = Location(),
    @PrimaryKey val id:Int? = null
)