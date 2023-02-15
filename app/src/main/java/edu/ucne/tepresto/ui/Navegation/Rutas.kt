package edu.ucne.tepresto.ui.Navegation



sealed class Rutas(var ruta: String){
    object Home: Rutas( "rutaHome")
    object OcupacionR: Rutas("RutaOcupacion")
    object  PersonaR: Rutas("RutaPersona")
}