package com.balyaba.carsalesmvvm.features.carslist

import android.util.Log
import androidx.lifecycle.ViewModel
import com.balyaba.repository.CarsRepository
import javax.inject.Inject


class CarsListViewModel @Inject constructor(
    private val carsRepository: CarsRepository
) : ViewModel() {
}