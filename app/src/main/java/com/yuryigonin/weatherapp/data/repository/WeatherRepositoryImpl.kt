package com.yuryigonin.weatherapp.data.repository

import com.yuryigonin.weatherapp.data.mappers.toWeatherInfo
import com.yuryigonin.weatherapp.domain.repository.WeatherRepository
import com.yuryigonin.weatherapp.domain.util.Resource
import com.yuryigonin.weatherapp.domain.weather.WeatherInfo
import com.yuryigonin.weatherapp.remote.WeatherApi
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}