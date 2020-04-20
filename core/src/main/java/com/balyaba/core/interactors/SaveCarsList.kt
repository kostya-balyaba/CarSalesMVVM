package com.balyaba.core.interactors

import com.balyaba.core.data.CarRepository
import com.balyaba.core.domain.Car

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
class SaveCarsList(private val carRepository: CarRepository) {
    operator fun invoke(carsList: List<Car>) = carRepository.saveAll(carsList)
}