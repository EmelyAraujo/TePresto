package edu.ucne.tepresto.ui.ocupacion
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import edu.ucne.tepresto.data.local.entity.OcupacionEntity
import edu.ucne.tepresto.ui.Navegation.Rutas
import edu.ucne.tepresto.ui.persona.PersonaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionScreen(viewModel: OcupacionViewModel = hiltViewModel()) {

    Column(Modifier.fillMaxSize()) {
        OcupacionBody(viewModel)

        val uiState by viewModel.uiState.collectAsState()
        OcupacionListScreen(uiState.ocupacionesList)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun OcupacionBody(
    viewModel: OcupacionViewModel
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = { Text("Registro de ocupaciones") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            },


            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Share, contentDescription = "Buscar")
                }

            }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.descripcion,
            onValueChange = {  viewModel.descripcion = it },
            label = { Text("Descripción") }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.sueldo,
            onValueChange = { viewModel.sueldo = it },
            label = { Text("Salario") }
        )

        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = { Text("Guardar") },
            icon = { Icon(imageVector = Icons.Filled.Save, contentDescription = "Save") },
            onClick = { viewModel.insertar() }
        )
    }
}

@Composable
private fun OcupacionListScreen(ocupacionList: List<OcupacionEntity>) {
    LazyColumn {
        items(ocupacionList) { ocupacion ->
            OcupacionRow(ocupacion)
        }
    }
}
@Composable
private fun OcupacionRow(ocupacion: OcupacionEntity) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = ocupacion.descripcion,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(3f)
            )
            Text(
                String.format("%.2f", ocupacion.sueldo),
                textAlign = TextAlign.End,
                modifier = Modifier.weight(2f)
            )
        }
        Divider(Modifier.fillMaxWidth())
    }
}