package com.nikasov.newidea.screen.advice

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.common.utils.State
import com.nikasov.newidea.navigation.main.MainRouter
import com.nikasov.presentation.widget.AdviceItem
import nikasov.domain.entitiy.Advice

@Composable
fun AdviceScreen(
    searchText: String,
    mainRouterEvent: (MainRouter) -> Unit,
    viewModel: AdviceViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LaunchedEffect(true) {
            viewModel.find(searchText)
        }

        val adviceList = viewModel.adviceList.collectAsState()

        when(adviceList.value) {
            is State.Error -> { }
            is State.Loading, State.Idle -> CircularProgressIndicator()
            is State.Successes -> {
                val list = (adviceList.value as State.Successes<List<Advice>>).data
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(list.size) {
                        val item = list[it]
                        Spacer(modifier = Modifier.height(6.dp))
                        AdviceItem(
                            text = item.text,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            onClick = {
                                mainRouterEvent(MainRouter.Advice(item.text))
                            }
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}