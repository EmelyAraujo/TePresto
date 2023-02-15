package edu.ucne.tepresto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.tepresto.ui.Navegation.HomeScreen
import edu.ucne.tepresto.ui.Navegation.Rutas
import edu.ucne.tepresto.ui.ocupacion.OcupacionScreen
import edu.ucne.tepresto.ui.persona.PersonaScreen
import edu.ucne.tepresto.ui.theme.TePrestoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TePrestoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph()
                }
            }
        }
    }
}


@Composable
fun NavigationGraph() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.Home.ruta  ){
        composable(route = Rutas.Home.ruta){
                HomeScreen(navController)
        }
        composable(route = Rutas.OcupacionR.ruta){

            OcupacionScreen()
        }

        composable(route = Rutas.PersonaR.ruta){
            PersonaScreen()
        }
    }
}