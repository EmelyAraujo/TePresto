package edu.ucne.tepresto.ui.Navegation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdsClick
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.tepresto.R
import edu.ucne.tepresto.ui.ocupacion.ConsultaOcupacionScreen
import edu.ucne.tepresto.ui.ocupacion.OcupacionScreen
import edu.ucne.tepresto.ui.persona.PersonaScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()

    ) {

        TopAppBar(
            title = { Text("Te Presto") },
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.Logout , contentDescription = "Localized description")
                }

            },
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
                                contentDescription = "Registro de Ocupacion"
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
                                contentDescription ="Registro de persona"
                            )
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Consulta de Ocupaciones") },
                        onClick = {
                            navController.navigate(route = Rutas.OcupacionC.ruta ){
                                popUpTo("rutaHome")
                            }
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.List,
                                contentDescription = "List ade ocupaciones"
                            )
                        })
                }

            }

        )
        Image(painter = painterResource(id = R.drawable.logoteprestoconbienvenida_removebg_preview),
            contentDescription = "Logo Inicio",
            modifier = Modifier
                .wrapContentSize(Alignment.CenterStart)
                .size(600.dp)

        )

    }
}

@Composable
fun NavigationGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Rutas.Home.ruta )
    {
        composable(route = Rutas.Home.ruta){
            HomeScreen(navController)
        }
        composable(route = Rutas.OcupacionR.ruta){

            OcupacionScreen()
        }

        composable(route = Rutas.PersonaR.ruta){
            PersonaScreen()
        }

        composable(route = Rutas.OcupacionC.ruta){
            ConsultaOcupacionScreen(onNew = {navController.navigate(route= Rutas.OcupacionR.ruta)})
        }
    }
}