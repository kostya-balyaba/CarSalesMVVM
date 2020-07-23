package com.balyaba.carsalesmvvm

import android.app.Application
import com.balyaba.carsalesmvvm.di.DaggerAppComponent
import com.balyaba.data.di.DatabaseModule
import com.balyaba.data.di.NetworkModule

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        appComponent.inject(this)
    }
}