package edu.ucne.tepresto.data.local.dao

import androidx.room.*
import edu.ucne.tepresto.data.local.entity.PersonaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(personaEntity: PersonaEntity)

    @Delete
    suspend fun delete(personaEntity: PersonaEntity)

    @Query("""
        SELECT * 
        FROM Personas
        WHERE PersonaId=:personaId
        LIMIT 1
    """)
    suspend fun find(personaId: Int): PersonaEntity?

    @Query("SELECT * FROM Personas")
    fun getList(): Flow<List<PersonaEntity>>

}

class personDao{
    fun save():Boolean{
        return true
    }
}