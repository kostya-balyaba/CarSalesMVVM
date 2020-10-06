package com.balyaba.carsalesmvvm.features.carslist.models

import com.balyaba.entities.Car

/*View States*/
data class CarsListViewState(
    val status: Status,
    val data: List<Car>,
    val errorMessage: String?
)

sealed class Status {
    object Success : Status()
    object Loading : Status()
    object Error : Status()
    object Empty : Status()
}

/*View Effects*/
sealed class CarsListViewEffect

data class OnStartCarDetailsScreen(val carId: Long) : CarsListViewEffect()

/*View Events*/
sealed class CarsListViewEvent