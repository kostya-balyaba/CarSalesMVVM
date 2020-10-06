package com.balyaba.data.features.cars.mapper

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.entities.Car
import javax.inject.Inject


class CarToCacheMapper @Inject constructor() : Mapper<Car, CarCacheDto> {
    override fun mapFromObject(source: Car): CarCacheDto =
        with(source) {
            CarCacheDto(
                id = id,
                name = name,
                engine = engine,
                gearbox = gearbox.toString(),
                carState = carState,
                photoUrl = photoUrl,
                safeDescription = safeDescription,
                comfortDescription = comfortDescription,
                description = description
            )
        }
}