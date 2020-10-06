package com.balyaba.carsalesmvvm.features.carslist

import androidx.lifecycle.viewModelScope
import com.balyaba.carsalesmvvm.common.vm.*
import com.balyaba.carsalesmvvm.features.carslist.adapter.CarsListAdapter
import com.balyaba.carsalesmvvm.features.carslist.models.*
import com.balyaba.entities.Car
import com.balyaba.repository.CarsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CarsListViewModel @Inject constructor(
    private val carsRepository: CarsRepository
) : BaseViewModel<CarsListViewState, CarsListViewEffect, CarsListViewEvent>() {

    init {
        viewState = CarsListViewState(Status.Loading, emptyList(), null)
    }

    fun loadCarsList() {
        viewModelScope.launchOperation {
            progress {
                viewState = CarsListViewState(Status.Loading, emptyList(), null)
            }
            work {
                val carsList = withContext(Dispatchers.IO) { carsRepository.getCarsList() }
                viewState = if (carsList.isNullOrEmpty())
                    viewState.copy(status = Status.Empty, data = emptyList())
                else
                    viewState.copy(status = Status.Success, data = carsList)
            }
            error {
                viewState = viewState.copy(status = Status.Error, errorMessage = it.toString())
            }
        }
    }

    override fun processEvent(viewEvent: CarsListViewEvent) {

    }

    val adapterListener = object : CarsListAdapter.OnItemClickListener {
        override fun carItemClicked(car: Car) {
            car.id?.let { viewEffect = OnStartCarDetailsScreen(it) }
        }
    }
}