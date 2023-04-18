package com.nikasov.newidea.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.common.utils.State
import com.nikasov.presentation.widget.AdviceHistoryItem

@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        favoriteViewModel.getAllFavorites()
    }

    val state = favoriteViewModel.screenState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when(state.value) {
            is State.Error -> { }
            is State.Loading, State.Idle -> { }
            is State.Successes -> {
                val list = (state.value as State.Successes<FavoriteScreenState>).data.adviceList
                LazyColumn {
                    items(list.size) { index ->
                        val item = list[index]
                        AdviceHistoryItem(
                            title = item.text,
                            isFavorite = item.isFavorite
                        )
                    }
                }
            }
        }
    }

}