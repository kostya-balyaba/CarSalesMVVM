package com.balyaba.repository

import com.balyaba.entities.Car

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 28.04.2020.
 */
interface CarsRepository {
    suspend fun getCarsList(): List<Car>

    suspend fun getCarById(id: Long): Car?

    suspend fun saveCarsList(carsList: List<Car>)
}