package com.example.weatherapp.screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.Current

@Composable
fun LowerItem(currentL: Current) {

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color.Gray.copy(0.09f))
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(horizontal = 16.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier.padding(30.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Feels like:",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Text(
                        text = currentL.feelslikeC.toInt().toString(),
                        color = Color.Gray.copy(0.6f),
                        textAlign = TextAlign.Left,
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }


                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Humidity",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Text(
                        text = currentL.humidity.toString(),
                        color = Color.Gray.copy(0.6f),
                        textAlign = TextAlign.Right,
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Wind speed",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Row(
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = currentL.windKph.toString(),
                            color = Color.Gray.copy(0.6f),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "km/h",
                            color = Color.Gray.copy(0.6f),
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Pressure",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Text(
                        text = currentL.pressureIn.toString(),
                        color = Color.Gray.copy(0.6f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "UV index",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Text(
                        text = currentL.uv.toString(),
                        color = Color.Gray.copy(0.6f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Cloud",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )

                    Text(
                        text = currentL.cloud.toString(),
                        color = Color.Gray.copy(0.6f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }

            }

        }

    }
}