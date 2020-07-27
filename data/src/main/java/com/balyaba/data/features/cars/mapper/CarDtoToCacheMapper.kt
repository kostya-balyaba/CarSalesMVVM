package com.balyaba.data.features.cars.mapper

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.dto.CarDto
import javax.inject.Inject

class CarDtoToCacheMapper @Inject constructor() : Mapper<CarDto, CarCacheDto> {
    override fun mapFromObject(source: CarDto): CarCacheDto =
        with(source) {
            CarCacheDto(
                id = id,
                name = name,
                engine = engine,
                gearbox = gearbox,
                carState = carState,
                photoUrl = photoUrl,
                safeDescription = safeDescription,
                comfortDescription = comfortDescription,
                description = description
            )
        }
}