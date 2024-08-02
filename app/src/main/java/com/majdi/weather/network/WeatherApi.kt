package com.majdi.weather.network

import com.majdi.weather.model.Weather
import com.majdi.weather.model.WeatherObject
import com.majdi.weather.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units : String = "metric",
        @Query("appid") appidd: String = API_KEY
    ) : Weather
}