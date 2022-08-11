package com.example.weatherapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Astro(
    @SerialName("moon_illumination")
    val moonIllumination: String = "",
    @SerialName("moon_phase")
    val moonPhase: String = "",
    @SerialName("moonrise")
    val moonrise: String = "",
    @SerialName("moonset")
    val moonset: String = "",
    @SerialName("sunrise")
    val sunrise: String = "",
    @SerialName("sunset")
    val sunset: String = ""
)