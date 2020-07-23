package com.balyaba.carsalesmvvm.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.balyaba.carsalesmvvm.R
import com.balyaba.data.features.cars.api.CarsApi
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 23.04.2020.
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var net: CarsApi

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}