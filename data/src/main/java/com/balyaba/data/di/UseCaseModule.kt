package com.balyaba.data.di

import com.balyaba.repository.CarsRepository
import com.balyaba.usecases.GetCarsListUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoriesModule::class])
class UseCaseModule {

    @Provides
    fun getCarsListUseCase(repository: CarsRepository): GetCarsListUseCase = GetCarsListUseCase(repository)
}