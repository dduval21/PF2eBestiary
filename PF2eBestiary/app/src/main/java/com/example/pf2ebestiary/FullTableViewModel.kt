package com.example.movies.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.model.Creature
import com.google.android.gms.common.api.Api
import kotlinx.coroutines.launch

sealed interface BestiaryUiState {
    data class Success(val movies: List<Creature>): BestiaryUiState
    object Error: BestiaryUiState
    object Loading: BestiaryUiState
}


class FullTableViewModel: ViewModel() {
    // private variable
    var bestiaryUiState: BestiaryUiState by mutableStateOf(BestiaryUiState.Loading)
        private set

    init{
        getTrendingMovies()
    }
    private fun getTrendingMovies() {
        viewModelScope.launch {
            bestiaryUiState = BestiaryUiState.Loading

            val listResult = packs/blood-lords-bestiary.retrofitService.getMovies()

            BestiaryUiState = try {
                val creatures = Api.retrofitService.getCreatures()
                BestiaryUiState.Success(
                    creatures = creatures.results
                )
            } catch (e: Exception) {
                MovieUiState.Error
            }
        }
    }
}