package com.majdi.weather.model

data class  WeatherItem(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feelsLike: FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<WeatherObject>
)