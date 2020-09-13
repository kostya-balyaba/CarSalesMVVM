package com.balyaba.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Unreal Mojo
 * @author Kostya Balyaba
 *         on 20.04.2020.
 */

@Parcelize
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
) : Parcelable {
    enum class Engine {
        AUTOMATIC, MANUAL, NOTHING
    }
}