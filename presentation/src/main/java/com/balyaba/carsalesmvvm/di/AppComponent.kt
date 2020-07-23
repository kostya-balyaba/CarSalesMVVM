package com.balyaba.carsalesmvvm.di

import android.content.Context
import com.balyaba.carsalesmvvm.App
import com.balyaba.carsalesmvvm.di.modules.ActivityModule
import com.balyaba.data.di.ApiModule
import com.balyaba.data.di.DataSourceModule
import com.balyaba.data.di.DatabaseModule
import com.balyaba.data.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ApiModule::class,
        DataSourceModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}