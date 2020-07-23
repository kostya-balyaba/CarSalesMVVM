package com.balyaba.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.balyaba.data.features.cars.cache.dto.CarCacheDto

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 21.04.2020.
 */
@Database(
    entities = [CarCacheDto::class],
    version = 1
)
abstract class CarsSalesDatabase : RoomDatabase() {

    abstract fun carsDao(): CarsDao
}