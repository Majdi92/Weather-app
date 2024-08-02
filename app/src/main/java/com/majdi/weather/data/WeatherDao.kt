package com.majdi.weather.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.majdi.weather.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * from fav_tabl")
    fun getFavorites(): Flow<List<Favorite>>

    @Query("SELECT * from fav_tabl where city =:city")
    suspend fun getFavById(city: String) : Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCity(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavoriteCity(favorite: Favorite)

    @Query("DELETE from fav_tabl")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavoriteCity(favorite: Favorite)
}