package com.balyaba.core.interactors

import com.balyaba.core.data.CarRepository

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
class ReadCarsList(private val carRepository: CarRepository) {
    operator fun invoke() = carRepository.readAll()
}