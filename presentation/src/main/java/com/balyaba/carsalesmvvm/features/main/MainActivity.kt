package com.balyaba.carsalesmvvm.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.balyaba.carsalesmvvm.R
import dagger.android.AndroidInjection

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 23.04.2020.
 */
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.main_nav_host_fragment_container)
    }
}