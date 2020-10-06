package com.balyaba.data.features.cars.datasource

import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.dto.CarDto
import retrofit2.Call

interface CarsDataSource {

    suspend fun getCarsList(): List<CarDto>

    suspend fun saveCarsList(carsList: List<CarCacheDto>)

    suspend fun getCarById(id: Long): CarDto?
}