package com.balyaba.data.features.cars.datasource

import com.balyaba.data.features.cars.dto.CarDto
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable

interface CarsDataSource {

    fun getCarsList(): Observable<List<CarDto>>

    fun saveCarsList(carsList: List<CarDto>)

    fun getCarById(id: Long): Maybe<CarDto>
}