package com.balyaba.core.data

import com.balyaba.core.domain.Car

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
interface CarDataSource {

    fun saveAll(carsList: List<Car>)

    fun readAll(): List<Car>
}