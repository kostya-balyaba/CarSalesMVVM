package com.balyaba.data.features.cars.mapper

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.dto.CarDto
import com.balyaba.entities.Car
import java.util.*
import javax.inject.Inject

class CarDtoToDomainMapper @Inject constructor() : Mapper<CarDto, Car> {
    override fun mapFromObject(source: CarDto): Car =
        with(source) {
            Car(
                id = id,
                name = name,
                engine = engine,
                gearbox = if (gearbox.equals("АВТОМАТ", true)) Car.Engine.AUTOMATIC else Car.Engine.MANUAL,
                carState = carState,
                photoUrl = photoUrl,
                safeDescription = safeDescription,
                comfortDescription = comfortDescription,
                description = description
            )
        }
}