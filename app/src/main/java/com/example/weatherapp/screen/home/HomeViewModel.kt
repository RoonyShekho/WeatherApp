package com.example.weatherapp.screen.home


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.Repository
import com.example.weatherapp.util.Constants.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val context: Context
) : ViewModel() {

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState>
        get() = _state


    private var isDatabaseEmpty by mutableStateOf(false)


    private fun loadDataFromApi(latLon: String) {
        viewModelScope.launch(Dispatchers.Main) {

            val items = repository.getWeatherInfo(latLon, apiKey = API_KEY)

            _state.value = state.value.copy(
                weather = items
            )

            repository.deleteAllItems()
            repository.saveWeather(items)
        }
        isDatabaseEmpty = false
    }

    private fun loadDataFromDatabase() {
        viewModelScope.launch {
                _state.value = state.value.copy(
                    weather = repository.getWeatherFromDatabase()
                )
        }
    }

    fun loadData(latLon: String) {
        val sdf = SimpleDateFormat("HH")
        val currentTime = sdf.format(Date())

        if (!isNetworkAvailable(context) && !isDatabaseEmpty) {
            loadDataFromDatabase()
        } else {
            if (state.value.weather.current.lastUpdated.drop(11)
                <
                (currentTime.toInt() - 1).toString()
            ) {
                loadDataFromApi(latLon)
            } else {
                loadDataFromDatabase()
            }
        }
    }


    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            val network = connectivityManager.activeNetwork ?: return false

            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                else -> false
            }

        } else {
            return false
        }
    }
}