package com.balyaba.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable

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
    fun getCars(): Observable<List<CarCacheDto>>

    @Query("SELECT * FROM car WHERE id = :id")
    fun getCarById(id: Long): Maybe<CarCacheDto>
}