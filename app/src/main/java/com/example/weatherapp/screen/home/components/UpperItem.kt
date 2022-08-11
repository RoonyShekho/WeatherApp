package com.example.weatherapp.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.ui.theme.textColor

@Composable
fun UpperItem(weather: Weather) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.padding(6.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.height(20.dp)
                    .width(20.dp)
                ,
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "location icon"
            )


            Text(text = weather.location.region, color = MaterialTheme.colors.textColor)
        }
        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Text(
                text = weather.current.tempC.toString(),
                fontSize = 100.sp,
                color = MaterialTheme.colors.textColor,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "°",
                color = MaterialTheme.colors.textColor,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
            )
        }


        AsyncImage(
            model = "https:" + weather.current.condition.icon,
            contentDescription = "",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
        )


        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = weather.current.condition.text,
            color = MaterialTheme.colors.textColor,
            textAlign = TextAlign.Center,
            fontSize = 50.sp
        )
    }

}