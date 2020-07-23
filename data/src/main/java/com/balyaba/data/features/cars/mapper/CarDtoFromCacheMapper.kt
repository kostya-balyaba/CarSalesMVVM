package com.nullgr.android.data.features.cars.mapper

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.dto.CarDto
import javax.inject.Inject

class CarDtoFromCacheMapper @Inject constructor() : Mapper<CarCacheDto, CarDto> {
    override fun mapFromObject(source: CarCacheDto): CarDto =
        with(source) {
            CarDto(
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