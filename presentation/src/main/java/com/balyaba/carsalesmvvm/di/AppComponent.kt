package com.balyaba.carsalesmvvm.di

import android.content.Context
import com.balyaba.carsalesmvvm.App
import com.balyaba.carsalesmvvm.di.modules.ActivityModule
import com.balyaba.carsalesmvvm.di.modules.FragmentModule
import com.balyaba.carsalesmvvm.di.modules.ViewModelModule
import com.balyaba.data.di.*
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
        FragmentModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ApiModule::class,
        DataSourceModule::class,
        RepositoriesModule::class,
        MappersModule::class
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