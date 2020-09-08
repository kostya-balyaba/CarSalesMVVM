package com.balyaba.data.features.cars.dto

import com.google.gson.annotations.SerializedName


data class CarDto(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("engine") val engine: String?,
    @SerializedName("gearbox") val gearbox: String?,
    @SerializedName("car_state") val carState: String?,
    @SerializedName("photo") val photoUrl: String?,
    @SerializedName("safe_description") val safeDescription: String?,
    @SerializedName("comfort_description") val comfortDescription: String?,
    @SerializedName("description") val description: String?
)