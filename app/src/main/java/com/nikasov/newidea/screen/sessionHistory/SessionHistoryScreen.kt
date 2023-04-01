package com.nikasov.newidea.screen.sessionHistory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.common.utils.State
import com.nikasov.newidea.navigation.main.MainRouter
import com.nikasov.presentation.widget.SessionHistoryItem

@Composable
fun SessionHistoryScreen(
    mainRouterEvent: (MainRouter) -> Unit,
    viewModel: SessionHistoryViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.getHistory()
    }

    val screenState = viewModel.screenState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when (screenState.value) {
            is State.Error -> {}
            is State.Loading, State.Idle -> CircularProgressIndicator()
            is State.Successes -> {
                val list = (screenState.value as State.Successes<SessionHistoryScreenState>).data.sessionList
                LazyColumn {
                    items(list.size) { position ->
                        val item = list[position]
                        SessionHistoryItem(
                            title = item.title,
                            date = item.date,
                            onClick = { mainRouterEvent(MainRouter.AdviceHistory(item.id)) }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HistoryScreenPreview() {
    SessionHistoryScreen({ })
}