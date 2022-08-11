package com.example.weatherapp.screen.home


import android.Manifest
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.screen.home.components.LowerItem
import com.example.weatherapp.screen.home.components.UpperItem
import com.example.weatherapp.ui.theme.DaySky
import com.example.weatherapp.ui.theme.MilkWhite
import com.example.weatherapp.ui.theme.NightSky
import com.example.weatherapp.util.RequestMultiplePermissions
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.gms.location.LocationServices
import java.text.SimpleDateFormat
import java.util.*


@ExperimentalMaterialApi
@SuppressLint("MissingPermission")
@ExperimentalPermissionsApi
@Composable
fun HomeScreen(
    vm: HomeViewModel = hiltViewModel()
) {


    val state by vm.state

    var index = 0

    val context = LocalContext.current

    val scrollableState = rememberScrollState()

    val sdf = SimpleDateFormat("HH")
    val currentTime = sdf.format(Date())


    var location by rememberSaveable { mutableStateOf("") }

    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    fusedLocationClient.lastLocation.addOnSuccessListener {

        location = "${it.latitude},${it.longitude}"
        vm.loadData(location)
    }


    Log.d("HomeScreen", location)



    RequestMultiplePermissions(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.48f)
            ) {

                Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.padding(4.dp)) {
                    LazyRow(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        for (i in state.weather.forecast.forecastday) {
                            for (j in i.hour) {
                                if (j.time.drop(11) == "$currentTime:00") {
                                    break
                                } else {
                                    index++
                                }
                            }



                            Log.d("HomeScreen", "index:$index")
                            items(i.hour.drop(index)) {
                                HourItem(hour = it)
                            }
                        }
                    }
                }

                Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.padding(20.dp)) {
                    LowerItem(currentL = state.weather.current)
                }
            }
        },
        sheetBackgroundColor = MilkWhite,
        sheetShape = RoundedCornerShape(60.dp),
        sheetPeekHeight = 110.dp,
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(scrollableState, orientation = Orientation.Vertical)
                .background(
                    if (state.weather.current.isDay == 1) DaySky
                    else NightSky
                )
                .clip(shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
        ) {

            UpperItem(weather = state.weather)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}