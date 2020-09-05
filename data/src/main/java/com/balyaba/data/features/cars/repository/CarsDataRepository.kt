package com.balyaba.data.features.cars.repository

import com.balyaba.data.common.Cache
import com.balyaba.data.common.Mapper
import com.balyaba.data.common.Remote
import com.balyaba.data.features.cars.datasource.CarsDataSource
import com.balyaba.data.features.cars.dto.CarDto
import com.balyaba.entities.Car
import com.balyaba.repository.CarsRepository
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class CarsDataRepository @Inject constructor(
    @Cache private val cachedSource: CarsDataSource,
    @Remote private val remoteSource: CarsDataSource,
    private val toDomainMapper: Mapper<CarDto, Car>,
    private val toCarDtoMapper: Mapper<Car, CarDto>
) : CarsRepository {

    override fun getCarsList(): Observable<List<Car>> =
        Observable.concat(remoteSource.getCarsList(), cachedSource.getCarsList())
            .take(1)
            .map(toDomainMapper::mapFromObjects)
            .doOnNext { carsList -> cachedSource.saveCarsList(toCarDtoMapper.mapFromObjects(carsList)) }

    override fun getCarById(id: Long): Maybe<Car> =
        cachedSource.getCarById(id)
            .map(toDomainMapper::mapFromObject)
}