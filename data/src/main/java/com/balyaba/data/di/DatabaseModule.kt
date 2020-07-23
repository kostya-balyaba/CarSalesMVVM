package com.balyaba.data.di

import android.content.Context
import androidx.room.Room
import com.balyaba.data.db.CarsDao
import com.balyaba.data.db.CarsSalesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Provides
    @Singleton
    fun provideCarsDatabase(context: Context): CarsSalesDatabase = Room.databaseBuilder(context, CarsSalesDatabase::class.java, "car.db").build()

    @Provides
    @Singleton
    fun provideCarsDao(database: CarsSalesDatabase): CarsDao = database.carsDao()
}