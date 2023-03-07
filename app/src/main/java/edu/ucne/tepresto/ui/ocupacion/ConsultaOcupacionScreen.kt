package edu.ucne.tepresto.ui.ocupacion


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.ucne.tepresto.data.local.entity.OcupacionEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultaOcupacionScreen(onNew: ()-> Unit) {
    val viewModel: OcupacionViewModel = hiltViewModel()
    val navController: NavHostController = rememberNavController()
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Consulta de Ocupaciones") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            },


            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(Icons.Filled.Search, contentDescription = "Buscar")
                }

            }
        )
        val uiState by viewModel.uiState.collectAsState()
        OcupacionListScreen(uiState.ocupacionesList)
    }

}


@Composable
fun OcupacionListScreen(ocupacionList: List<OcupacionEntity>) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(ocupacionList) { ocupacion ->
            OcupacionRow(ocupacion)
        }
    }
}

@Composable
private fun OcupacionRow(ocupacion: OcupacionEntity) {
    //TODO Implementar swipe to delete
    Card(
        shape = RoundedCornerShape(1.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
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
}

