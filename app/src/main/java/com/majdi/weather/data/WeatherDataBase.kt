package com.majdi.weather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.majdi.weather.model.Favorite


@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao



}