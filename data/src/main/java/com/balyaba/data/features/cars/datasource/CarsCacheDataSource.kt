package com.nullgr.android.data.features.cars.datasource

import com.balyaba.data.common.Mapper
import com.balyaba.data.db.CarsDao
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.datasource.CarsDataSource
import com.balyaba.data.features.cars.dto.CarDto
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class CarsCacheDataSource @Inject constructor(
    private val toCacheMapper: Mapper<CarDto, CarCacheDto>,
    private val fromCacheMapper: Mapper<CarCacheDto, CarDto>,
    private val carsDao: CarsDao
) : CarsDataSource {

    override fun getCarsList(): Observable<List<CarDto>> =
        carsDao.getCars()
            .map(fromCacheMapper::mapFromObjects)

    override fun saveCarsList(carsList: List<CarDto>) =
        carsDao.saveCars(toCacheMapper.mapFromObjects(carsList))

    override fun getCarById(id: Long): Maybe<CarDto> {
        val carDto = carsDao.getCarById(id)
        return carDto.isEmpty.flatMapMaybe { empty ->
            if (!empty)
                carDto.map(fromCacheMapper::mapFromObject)
            else
                Maybe.empty()
        }
    }
}