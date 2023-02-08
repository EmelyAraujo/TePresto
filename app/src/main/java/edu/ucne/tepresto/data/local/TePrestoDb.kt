package edu.ucne.tepresto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.tepresto.data.local.dao.OcupacionDao
import edu.ucne.tepresto.data.local.dao.PersonaDao
import edu.ucne.tepresto.data.local.entity.OcupacionEntity
import edu.ucne.tepresto.data.local.entity.PersonaEntity

@Database(
    entities = [
        OcupacionEntity::class,
        PersonaEntity::class
    ],
    version = 2
)
abstract  class TePrestoDb: RoomDatabase(){
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}