package com.balyaba.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.balyaba.data.features.cars.cache.dto.CarCacheDto

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 21.04.2020.
 */
@Dao
interface CarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCars(carsList: List<CarCacheDto>)

    @Query("SELECT * FROM car")
    fun getCars(): List<CarCacheDto>

    @Query("SELECT * FROM car WHERE id = :id")
    fun getCarById(id: Long): CarCacheDto?
}