package com.nikasov.newidea.screen.adviceHostory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

@HiltViewModel
class AdviceHistoryViewModel @Inject constructor(
    private val chatRepository: ChatRepository
): ViewModel() {

    private val _screenState = MutableStateFlow<State<AdviceHistoryScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getHistory(sessionId: Long) {
        viewModelScope.launch {
            val sessions = chatRepository.getSession(sessionId)
            _screenState.emit(State.successes(AdviceHistoryScreenState(sessions)))
        }
    }

}