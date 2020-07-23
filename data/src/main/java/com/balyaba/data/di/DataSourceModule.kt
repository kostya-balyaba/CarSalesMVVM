package com.balyaba.data.di

import com.balyaba.data.common.Cache
import com.balyaba.data.common.Remote
import com.nullgr.android.data.features.cars.datasource.CarsCacheDataSource
import com.nullgr.android.data.features.cars.datasource.CarsDataSource
import com.nullgr.android.data.features.cars.datasource.CarsRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Cache
    @Binds
    @Singleton
    fun bindCarsCacheDataSource(source: CarsCacheDataSource): CarsDataSource

    @Remote
    @Binds
    @Singleton
    fun bindCarsRemoteDataSource(source: CarsRemoteDataSource): CarsDataSource
}