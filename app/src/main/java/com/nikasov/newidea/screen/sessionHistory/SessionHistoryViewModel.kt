package com.nikasov.newidea.screen.sessionHistory

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
class SessionHistoryViewModel @Inject constructor(
    private val chatRepository: ChatRepository
): ViewModel() {

    private val _screenState = MutableStateFlow<State<SessionHistoryScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getHistory() {
        viewModelScope.launch {
            val sessions = chatRepository.getAllSessions()
            _screenState.emit(State.successes(SessionHistoryScreenState(sessions)))
        }
    }

}