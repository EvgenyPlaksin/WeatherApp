package com.example.weatherapp.repository

import com.example.weatherapp.api.ApiService
import javax.inject.Inject
// ну тут проблем быть не должно
class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeather()
}