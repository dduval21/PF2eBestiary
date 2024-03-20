package com.example.movies

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.theme.FullTableScreen
import com.example.movies.ui.theme.FullTableViewModel
import com.example.movies.ui.theme.TopNav
import com.example.pf2ebestiary.FamiliesScreen
import com.example.pf2ebestiary.FullTableScreen
import com.example.pf2ebestiary.FullTableViewModel
import com.example.pf2ebestiary.LevelScreen
import com.example.pf2ebestiary.TypeScreen
import com.example.pf2ebestiary.ui.theme.PF2eBestiaryTheme

sealed class Destination (val route: String) {
    object FullTable: Destination("table")
    object Families: Destination("families")
    object Level: Destination("level")
    object Type: Destination("type")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PF2eBestiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // controller
                    val navController = rememberNavController()
                    BestiaryScaffold(navController)
                }
            }
        }
    }
}

// controller: coordinates navigation throughout the app
// navhost: ui element, swaps out destinations
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun BestiaryScaffold(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopNav(navController = navController)
        }
    ) {
            paddingValues ->
        val movieViewModel: FullTableViewModel = viewModel()

        NavHost(navController = navController, startDestination = Destination.FullTable.route) {
            composable(Destination.FullTable.route) {
                FullTableScreen(FullTableViewModel.bestiaryUiState)
            }

            composable(Destination.Families.route) {
                FamiliesScreen()
            }

            composable(Destination.Level.route) {
                LevelScreen()
            }

            composable(Destination.Type.route) {
                TypeScreen()
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String
    weight: Float
){
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun TableScreen() {
    // Just a fake data... a Pair of Int and String
    val tableData = (1..100).mapIndexed { index, item ->
        index to "Item $index"
    }
    // Each cell of a column must have the same weight.
    val column1Weight = .3f // 30%
    val column2Weight = .7f // 70%
    // The LazyColumn will be our table. Notice the use of the weights below
    LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
        // Here is the header
        item {
            Row(Modifier.background(Color.Gray)) {
                TableCell(text = "Column 1", weight = column1Weight)
                TableCell(text = "Column 2", weight = column2Weight)
            }
        }
        // Here are all the lines of your table.
        items(tableData) {
            val (id, text) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = id.toString(), weight = column1Weight)
                TableCell(text = text, weight = column2Weight)
            }
        }
    }
}

