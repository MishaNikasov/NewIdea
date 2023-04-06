package com.nikasov.newidea.screen.adviceHostory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.common.utils.State
import com.nikasov.presentation.widget.AdviceHistoryItem

@Composable
fun AdviceHistoryScreen(
    sessionId: Long,
    viewModel: AdviceHistoryViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.getHistory(sessionId)
    }

    val screenState = viewModel.screenState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when (screenState.value) {
            is State.Error -> {}
            is State.Loading, State.Idle -> CircularProgressIndicator()
            is State.Successes -> {
                val list = (screenState.value as State.Successes<AdviceHistoryScreenState>).data.session.advices
                LazyColumn {
                    items(list.size) { position ->
                        val item = list[position]
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

@Preview
@Composable
fun AdviceHistoryScreenPreview() {
    AdviceHistoryScreen(0L)
}