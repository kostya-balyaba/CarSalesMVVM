package com.balyaba.data.features.cars.cache.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 21.04.2020.
 */
@Entity(tableName = "car")
data class CarCacheDto(
    @PrimaryKey
    val id: Long,
    val name: String,
    val engine: String,
    val gearbox: String,
    val carState: String,
    val photoUrl: String,
    @ColumnInfo(name = "safe_description")
    val safeDescription: String,
    @ColumnInfo(name = "comfort_description")
    val comfortDescription: String,
    val description: String
)