package com.balyaba.carsalesmvvm.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.balyaba.carsalesmvvm.common.vm.ViewModelFactory
import com.balyaba.carsalesmvvm.common.vm.VmKey
import com.balyaba.carsalesmvvm.features.carslist.CarsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @VmKey(CarsListViewModel::class)
    abstract fun bindCarsListViewModel(viewModel: CarsListViewModel): ViewModel
}