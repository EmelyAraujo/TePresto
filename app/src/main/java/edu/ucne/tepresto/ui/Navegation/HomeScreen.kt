package edu.ucne.tepresto.ui.Navegation


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Te Presto") },
            navigationIcon = {
                IconButton(onClick = {expanded = true  }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false })
                {
                    DropdownMenuItem(
                        text = { Text("Registro de Ocupaciones") },
                        onClick = {
                            navController.navigate(route = Rutas.OcupacionR.ruta ){
                                popUpTo("rutaHome")
                            }
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Add,
                                contentDescription = null
                            )
                        })
                    DropdownMenuItem(
                        text = { Text("Registro de Persona") },
                        onClick = {
                            navController.navigate(route = Rutas.PersonaR.ruta ){
                                popUpTo("rutaHome")

                            }
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.People,
                                contentDescription = null
                            )
                        })
                }

            },

            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                }

            }
        )

    }
}


@Composable
fun MenuScreen() {


}