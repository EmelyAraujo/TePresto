package edu.ucne.tepresto.ui.Navegation

sealed class Rutas(var ruta: String){
    object Home: Rutas( "rutaHome")
    object OcupacionR: Rutas("RutaOcupacion/{idOcupacion}"){
        fun crearRuta(idOcupacion: Int): String {
            return "rutaOcupacion/$idOcupacion"
        }
    }

    object  PersonaR: Rutas("RutaPersona")
    object OcupacionC: Rutas("RutaOcupaciones")
}

