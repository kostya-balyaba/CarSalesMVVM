package com.balyaba.data.features.cars.datasource

import com.balyaba.data.features.cars.api.CarsApi
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.dto.CarDto
import javax.inject.Inject

class CarsRemoteDataSource @Inject constructor(
    private val carsApi: CarsApi
) : CarsDataSource {

    override suspend fun getCarsList(): List<CarDto> =
        carsApi.getCarsList()

    override suspend fun saveCarsList(carsList: List<CarCacheDto>) {
        throw IllegalStateException("saveCarsList method dose not support by remote data source")
    }


    override suspend fun getCarById(id: Long): CarDto {
        throw IllegalStateException("getCarById method dose not support by remote data source")
    }
}