package edu.ucne.tepresto.data.local.entity

import android.app.AuthenticationRequiredException
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Ocupaciones")
data class OcupacionEntity(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int?=null,
    val descripcion: String = "",
    val descripcionError: String? = null,
    val sueldo: Double = 0.0,
    val sueldoError: Double? = null


)