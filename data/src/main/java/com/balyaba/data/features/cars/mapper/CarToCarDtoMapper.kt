package com.balyaba.data.features.cars.mapper

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.dto.CarDto
import com.balyaba.entities.Car
import javax.inject.Inject

class CarToCarDtoMapper @Inject constructor() : Mapper<Car, CarDto> {
    override fun mapFromObject(source: Car): CarDto =
        with(source) {
            CarDto(
                id = id,
                name = name,
                engine = engine,
                gearbox = gearbox.name,
                carState = carState,
                photoUrl = photoUrl,
                safeDescription = safeDescription,
                comfortDescription = comfortDescription,
                description = description
            )
        }
}