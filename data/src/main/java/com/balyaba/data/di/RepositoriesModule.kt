package com.balyaba.data.di

import com.balyaba.data.features.cars.repository.CarsDataRepository
import com.balyaba.repository.CarsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DataSourceModule::class])
interface RepositoriesModule {

    @Binds
    @Singleton
    fun bindCarsRepository(repo: CarsDataRepository): CarsRepository
}