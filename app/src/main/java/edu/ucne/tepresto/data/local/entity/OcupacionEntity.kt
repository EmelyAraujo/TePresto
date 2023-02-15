package edu.ucne.tepresto.data.local.entity

import android.app.AuthenticationRequiredException
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Ocupaciones")
data class OcupacionEntity(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int?=null,
    val descripcion: String,
    val sueldo: Double


)