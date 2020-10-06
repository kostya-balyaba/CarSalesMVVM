package com.nullgr.android.data.features.cars.datasource

import com.balyaba.data.common.Mapper
import com.balyaba.data.db.CarsDao
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.datasource.CarsDataSource
import com.balyaba.data.features.cars.dto.CarDto
import javax.inject.Inject

class CarsCacheDataSource @Inject constructor(
    private val toCacheMapper: Mapper<CarDto, CarCacheDto>,
    private val fromCacheMapper: Mapper<CarCacheDto, CarDto>,
    private val carsDao: CarsDao
) : CarsDataSource {

    override suspend fun getCarsList(): List<CarDto> {
        val a = Thread.currentThread()
        val result = mutableListOf<CarDto>()
        val cachedCars = carsDao.getCars()
        return if (!cachedCars.isNullOrEmpty()) {
            result.addAll(fromCacheMapper.mapFromObjects(cachedCars))
            result
        } else emptyList()
    }

    override suspend fun saveCarsList(carsList: List<CarCacheDto>) {
        carsDao.saveCars(carsList)
    }

    override suspend fun getCarById(id: Long): CarDto? {
        return carsDao.getCarById(id)?.let { fromCacheMapper.mapFromObject(it) }
    }
}