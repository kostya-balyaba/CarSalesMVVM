package com.balyaba.data.features.cars.dto

import com.google.gson.annotations.SerializedName


data class CarDto(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("engine") val engine: String?,
    @SerializedName("gearbox") val gearbox: String?,
    @SerializedName("carState") val carState: String?,
    @SerializedName("photoUrl") val photoUrl: String?,
    @SerializedName("safeDescription") val safeDescription: String?,
    @SerializedName("comfortDescription") val comfortDescription: String?,
    @SerializedName("description") val description: String?
)