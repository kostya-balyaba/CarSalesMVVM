package com.balyaba.data.features.cars.api

import com.balyaba.data.features.cars.dto.CarDto
import io.reactivex.Observable

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 28.04.2020.
 */
data class CarsListResult(val carList: Observable<List<CarDto>>)