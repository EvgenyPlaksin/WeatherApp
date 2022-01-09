package com.example.weatherapp.api

import com.example.weatherapp.model.Weather
import com.example.weatherapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather/Kiev") // дополнение к https://goweather.herokuapp.com/
    suspend fun getWeather(): Response<Weather>

}