package com.balyaba.data.features.cars.api

import com.balyaba.data.features.cars.dto.CarDto
import retrofit2.http.GET

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 28.04.2020.
 */
interface CarsApi {
    @GET("CarSalesMVVM/posts")
    suspend fun getCarsList(): List<CarDto>
}