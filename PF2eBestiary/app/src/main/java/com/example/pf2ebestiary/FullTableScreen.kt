package com.example.movies.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pf2ebestiary.R

@Composable
fun FullTableScreen(bestiaryUiState: BestiaryUiState,
                modifier: Modifier = Modifier) {

    Column () {
        when(bestiaryUiState) {
            is BestiaryUiState.Loading -> Text("Loading!")
            is BestiaryUiState.Error -> Text(stringResource(R.string.error_no_creatures))
            is BestiaryUiState.Success -> {
                LazyColumn {
                    items(BestiaryUiState.creatures) {
                            creature ->
                        CreatureCard(creatureItem = creature)
                    }
                }
            }
        }
    }

}