package com.example.weatherapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val DaySky = Color(135, 206, 235)


val transparent = Color(255,255,255)

val NightSky = Color(42,24,53)

val MilkWhite = Color(253, 254, 255)


val Colors.textColor
    @Composable
    get() = if (isLight) DarkGray else White

val Colors.backgroundColor
    @Composable
    get() = if (isLight) DaySky else Black