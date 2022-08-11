package com.example.weatherapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("country")
    val country: String = "",
    @SerialName("lat")
    val lat: Double = 0.0,
    @SerialName("localtime")
    val localtime: String = "",
    @SerialName("localtime_epoch")
    val localtimeEpoch: Int = 0,
    @SerialName("lon")
    val lon: Double = 0.0,
    @SerialName("name")
    val name: String = "",
    @SerialName("region")
    val region: String = "",
    @SerialName("tz_id")
    val tzId: String = ""
)