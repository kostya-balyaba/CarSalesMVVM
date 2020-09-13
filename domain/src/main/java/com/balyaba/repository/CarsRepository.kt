package com.balyaba.repository

import com.balyaba.entities.Car
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 28.04.2020.
 */
interface CarsRepository {
    fun getCarsList(): Observable<List<Car>>

    fun getCarById(id: Long): Maybe<Car>
}