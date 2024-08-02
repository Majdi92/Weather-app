package com.majdi.weather.repository

import com.majdi.weather.data.WeatherDao
import com.majdi.weather.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao) {

    fun getFavorites() : Flow<List<Favorite>> = weatherDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavoriteCity(favorite)
    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavoriteCity(favorite)
    suspend fun updateFavorite(favorite: Favorite) = weatherDao.updateFavoriteCity(favorite)
    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorites()
    suspend fun getFavById(city: String) : Favorite = weatherDao.getFavById(city)


}