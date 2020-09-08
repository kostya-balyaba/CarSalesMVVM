package com.balyaba.carsalesmvvm.features.carslist

import androidx.lifecycle.ViewModel
import com.balyaba.usecases.GetCarsListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


class CarsListViewModel @Inject constructor(
    val getCarsListUseCase: GetCarsListUseCase
) : ViewModel() {

    val viewState: BehaviorSubject<CarsListViewState> = BehaviorSubject.createDefault(CarsListViewState.Loading)
    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    fun obtainEvent(event: CarsListViewEvent) {
        when (event) {
            CarsListViewEvent.LoadCarsList -> loadCarsList()
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    private fun loadCarsList() {
        compositeDisposable.add(
            getCarsListUseCase.invoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.onNext(CarsListViewState.Success(it))
                }, {
                    viewState.onNext(CarsListViewState.ShowError("some error"))
                })
        )
    }
}