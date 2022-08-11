package com.example.weatherapp.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.Hour
import com.skydoves.landscapist.glide.GlideImage
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HourItem(hour: Hour) {

    val sdf = SimpleDateFormat("HH")
    val currentTime = sdf.format(Date())


    Column(
        modifier = Modifier
            .wrapContentWidth()
            .clip(shape = RoundedCornerShape(12.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val icon = hour.condition.icon

        GlideImage(
            imageModel = "https:$icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )

        Text(
            text = if ("$currentTime:00" == hour.time.drop(11)) "Now"
            else hour.time.drop(11),
            color = Color.Gray.copy(0.6f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = hour.tempC.toString(),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}