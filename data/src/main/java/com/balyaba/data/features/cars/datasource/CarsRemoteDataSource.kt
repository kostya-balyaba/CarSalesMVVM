package com.balyaba.data.features.cars.datasource

import com.balyaba.data.features.cars.api.CarsApi
import com.balyaba.data.features.cars.dto.CarDto
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class CarsRemoteDataSource @Inject constructor(
    private val carsApi: CarsApi
) : CarsDataSource {

    override fun getCarsList(): Observable<List<CarDto>> =
        carsApi.getCarsList()

    override fun saveCarsList(carsList: List<CarDto>) {
        throw IllegalStateException("saveCarsList method dose not support by remote data source")
    }

    override fun getCarById(id: Long): Maybe<CarDto> =
        Maybe.error(IllegalStateException("getCarById method dose not support by remote data source"))
}