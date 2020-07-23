package com.balyaba.carsalesmvvm.di.modules

import com.balyaba.carsalesmvvm.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}