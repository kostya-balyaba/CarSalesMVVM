package com.balyaba.carsalesmvvm.features.main

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.balyaba.carsalesmvvm.R
import com.balyaba.carsalesmvvm.common.utils.NetworkUtils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

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
        NavigationUI.setupWithNavController(bottom_navigation_view, navController)
        initNetworkConnectionView()
    }

    private fun initNetworkConnectionView() {
        val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        var isInitialConnection = true

        NetworkUtils.getNetworkLiveData(this).observe(this, Observer { isConnected ->
            if (isInitialConnection && isConnected) {
                return@Observer
            }
            isInitialConnection = false
            if (isConnected) {
                noInternetView.startAnimation(animFadeOut)
            } else {
                noInternetView.startAnimation(animFadeIn)
            }
        })
    }
}