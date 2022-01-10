package com.example.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
// делаю биндиг (или байндинг?)
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // инициализирую биндиг или байндинг
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS)
        val formattedTomorrow = tomorrow.format(DateTimeFormatter.ofPattern("EE, MMM d"))

        val tomorrow1 = LocalDate.now().plus(2, ChronoUnit.DAYS)
        val formattedTomorrow1 = tomorrow1.format(DateTimeFormatter.ofPattern("EE, MMM d"))

        val tomorrow2 = LocalDate.now().plus(3, ChronoUnit.DAYS)
        val formattedTomorrow2 = tomorrow2.format(DateTimeFormatter.ofPattern("EE, MMM d"))

        viewModel.weatherResponse.observe(this, { weather ->

            binding.apply {
                tvCityName.text = "London"
                tvDescription.text = weather.description
                tvTemperature.text = weather.temperature
                tvWind.text = weather.wind

                val forecast = weather.forecast
                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"

                day1.text = formattedTomorrow
                day2.text = formattedTomorrow1
                day3.text = formattedTomorrow2
            }

        })
    }
}