package com.balyaba.carsalesmvvm.di.modules

import com.balyaba.carsalesmvvm.features.carslist.CarsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindCarsListFragment(): CarsListFragment
}