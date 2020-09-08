package com.balyaba.usecases

import com.balyaba.repository.CarsRepository
import javax.inject.Inject

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */
class GetCarsListUseCase @Inject constructor(private val carRepository: CarsRepository) {
    operator fun invoke() = carRepository.getCarsList()
}