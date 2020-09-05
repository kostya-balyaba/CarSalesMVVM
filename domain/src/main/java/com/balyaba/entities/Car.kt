package com.balyaba.entities

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */

data class Car(
    val id: Long?,
    val name: String?,
    val engine: String?,
    val gearbox: Engine?,
    val carState: String?,
    val photoUrl: String?,
    val safeDescription: String?,
    val comfortDescription: String?,
    val description: String?
) {
    enum class Engine {
        AUTOMATIC, MANUAL, NOTHING
    }
}