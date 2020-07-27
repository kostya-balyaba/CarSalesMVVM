package com.balyaba.data.di

import com.balyaba.data.common.Mapper
import com.balyaba.data.features.cars.cache.dto.CarCacheDto
import com.balyaba.data.features.cars.dto.CarDto
import com.balyaba.entities.Car
import com.balyaba.data.features.cars.mapper.CarDtoFromCacheMapper
import com.balyaba.data.features.cars.mapper.CarDtoToCacheMapper
import com.balyaba.data.features.cars.mapper.CarDtoToDomainMapper
import com.balyaba.data.features.cars.mapper.CarToCarDtoMapper

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
@Suppress("UnnecessaryAbstractClass", "TooManyFunctions")
abstract class MappersModule {

    @Binds
    @Singleton
    abstract fun bindCarDtoFromCacheMapper(mapper: CarDtoFromCacheMapper): Mapper<CarCacheDto, CarDto>

    @Binds
    @Singleton
    abstract fun bindCarDtoToCacheMapper(mapper: CarDtoToCacheMapper): Mapper<CarDto, CarCacheDto>

    @Binds
    @Singleton
    abstract fun bindCarDtoToDomainMapper(mapper: CarDtoToDomainMapper): Mapper<CarDto, Car>

    @Binds
    @Singleton
    abstract fun bindCarToCarDtoMapper(mapper: CarToCarDtoMapper): Mapper<Car, CarDto>
}