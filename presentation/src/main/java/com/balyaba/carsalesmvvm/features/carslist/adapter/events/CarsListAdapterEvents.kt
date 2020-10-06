package com.balyaba.carsalesmvvm.features.carslist.adapter.events

import com.balyaba.carsalesmvvm.common.ui.adapter.listener.ItemEvent
import com.balyaba.entities.Car


sealed class CarsListAdapterEvents : ItemEvent {

    data class CarItemClicked(val car: Car) : CarsListAdapterEvents()
}