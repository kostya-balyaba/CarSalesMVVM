package com.balyaba.data.di

import com.balyaba.data.features.cars.api.CarsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    fun provideCarsApi(retrofit: Retrofit): CarsApi = retrofit.create(CarsApi::class.java)
}