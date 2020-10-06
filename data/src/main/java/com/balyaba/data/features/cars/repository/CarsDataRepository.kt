package com.balyaba.data.features.cars.repository

import com.balyaba.data.common.Cache
import com.balyaba.data.common.Mapper
import com.balyaba.data.common.Remote
import com.balyaba.data.common.network.ServerError
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.datasource.CarsDataSource
import com.balyaba.data.features.cars.dto.CarDto
import com.balyaba.entities.Car
import com.balyaba.repository.CarsRepository
import javax.inject.Inject

class CarsDataRepository @Inject constructor(
    @Cache private val cachedSource: CarsDataSource,
    @Remote private val remoteSource: CarsDataSource,
    private val toDomainMapper: Mapper<CarDto, Car>,
    private val toCarCacheDtoMapper: Mapper<Car, CarCacheDto>
) : CarsRepository {

    override suspend fun getCarsList(): List<Car> {
        var carsFromApi: List<CarDto> = emptyList()
        val carsFromDb: List<CarDto>

        try {
            carsFromApi = remoteSource.getCarsList()
        } catch (e: Exception) {
            if (carsFromApi.isNullOrEmpty()) {
                carsFromDb = cachedSource.getCarsList()
                if (!carsFromDb.isNullOrEmpty())
                    return toDomainMapper.mapFromObjects(carsFromDb)
                else throw ServerError
            }
        }

        val cars = toDomainMapper.mapFromObjects(carsFromApi)
        cachedSource.saveCarsList(toCarCacheDtoMapper.mapFromObjects(cars))
        return cars
    }

    override suspend fun saveCarsList(carsList: List<Car>) {
        cachedSource.saveCarsList(toCarCacheDtoMapper.mapFromObjects(carsList))
    }

    override suspend fun getCarById(id: Long): Car? {
        val carDto: CarDto? = cachedSource.getCarById(id)
        return carDto?.let { toDomainMapper.mapFromObject(it) }
    }
}