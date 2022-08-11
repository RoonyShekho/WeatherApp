package com.example.weatherapp.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    @SerialName("code")
    val code: Int = 0,
    @SerialName("icon")
    val icon: String = "",
    @SerialName("text")
    val text: String = ""
)