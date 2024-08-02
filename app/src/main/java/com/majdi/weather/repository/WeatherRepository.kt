package com.majdi.weather.repository

import android.util.Log
import com.majdi.weather.data.DataOrException
import com.majdi.weather.model.Weather
import com.majdi.weather.model.WeatherObject
import com.majdi.weather.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery)
        } catch (e: Exception) {


            Log.e("getWeatherResponse",e.message.toString() )
            return DataOrException(e = e)
        }
        Log.d(  "getWeatherResponse: ",response.toString())
        return DataOrException(data = response)
    }
}