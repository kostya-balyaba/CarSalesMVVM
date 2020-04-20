package com.balyaba.core.data

import com.balyaba.core.domain.Car

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
class CarRepository(private val carDataSource: CarDataSource) {

    fun saveAll(cars: List<Car>) = carDataSource.saveAll(cars)

    fun readAll(): List<Car> = carDataSource.readAll()
}