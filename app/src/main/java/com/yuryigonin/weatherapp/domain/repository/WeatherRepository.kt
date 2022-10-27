package com.yuryigonin.weatherapp.domain.repository

import com.yuryigonin.weatherapp.domain.util.Resource
import com.yuryigonin.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>


}