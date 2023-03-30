package com.nikasov.newidea.screen.advice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nikasov.common.utils.State
import com.nikasov.presentation.widget.AdviceItem
import nikasov.domain.entitiy.Advice

@Composable
fun AdviceScreen(
    searchText: String,
    viewModel: AdviceViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val adviceList = viewModel.adviceList.collectAsState()

        when(adviceList.value) {
            is State.Error -> { }
            is State.Loading, State.Idle -> {
                CircularProgressIndicator()
            }
            is State.Successes -> {
                val list = (adviceList.value as State.Successes<List<Advice>>).data
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(list.size) {
                        val item = list[it]
                        AdviceItem(
                            text = item.text,
                            onClick = {

                            }
                        )
                    }
                }
            }
        }

        LaunchedEffect(true) {
            viewModel.find(searchText)
        }
    }
}