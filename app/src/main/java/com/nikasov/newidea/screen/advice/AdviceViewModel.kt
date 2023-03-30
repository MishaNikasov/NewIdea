package com.nikasov.newidea.screen.advice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.DataState
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.ChatRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {

    private val _adviceList = MutableStateFlow<State<List<Advice>>>(State.Idle)
    val adviceList = _adviceList.asStateFlow()

    fun find(query: String) {
        viewModelScope.launch {
            _adviceList.emit(State.loading())
            when (val result = chatRepository.getAdvices(query)) {
                is DataState.Error -> { }
                is DataState.Success -> {
                    _adviceList.emit(State.successes(result.data ?: emptyList()))
                    Timber.d("find: ${result.data?.joinToString { it.text }}")
                }
            }
        }
    }

}