package edu.ucne.tepresto.ui.persona

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.tepresto.data.local.entity.PersonaEntity
import edu.ucne.tepresto.data.repository.PersonaRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    private val personaRepository: PersonaRepository
) : ViewModel() {
    var nombres by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("dd/mm/yyyy")
    var ocupacionId by mutableStateOf(0)

    fun insertar(nombres: String, telefono: String, celular: String, email: String, direccion: String,fechaNacimiento: String ) {

        val persona = PersonaEntity(
            nombres = nombres,
            telefono = telefono,
            celular = celular,
            email = email,
            direccion = direccion,
            fechaNacimiento = fechaNacimiento

        )

        viewModelScope.launch {
            personaRepository.insert(persona)
        }
    }
}