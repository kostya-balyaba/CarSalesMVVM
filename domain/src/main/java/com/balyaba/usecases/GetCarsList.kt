package com.balyaba.usecases

import com.balyaba.repository.CarsRepository

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
class GetCarsList(private val carRepository: CarsRepository) {
    operator fun invoke() = carRepository.getCarsList()
}