package com.balyaba.carsalesmvvm.features.carslist

import com.balyaba.entities.Car

sealed class CarsListViewEvent {
    object LoadCarsList : CarsListViewEvent()
}

sealed class CarsListViewState {
    data class Success(val data: List<Car>) : CarsListViewState()
    object Loading : CarsListViewState()
    data class ShowError(val message: String) : CarsListViewState()
}