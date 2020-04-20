package com.balyaba.core.domain

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */

data class Car(
    val name: String,
    val engine: String,
    val gearbox: String,
    val carState: String,
    val photoUrl: String,
    val safeDescription: String,
    val comfortDescription: String,
    val description: String
)