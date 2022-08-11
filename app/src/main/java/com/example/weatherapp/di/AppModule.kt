package com.example.weatherapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.weatherapp.data.database.WeatherDatabase
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.repository.Repository
import com.example.weatherapp.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private val httpLoggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideRepository(weatherApi: WeatherApi, weatherDatabase: WeatherDatabase): Repository {
        return Repository(weatherApi, weatherDatabase.weatherDao)
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext


    private val json = Json {
        ignoreUnknownKeys = true
    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttp: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(okHttp)
            .build()
    }


    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(app, WeatherDatabase::class.java, "weather_db")
            .build()
    }


    @Singleton
    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit
    ): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}