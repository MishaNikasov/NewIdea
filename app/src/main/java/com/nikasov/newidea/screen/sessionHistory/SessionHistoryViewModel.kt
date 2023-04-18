package com.nikasov.newidea.screen.sessionHistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.usecase.chat.GetAllSessionsUseCase
import javax.inject.Inject

@HiltViewModel
class SessionHistoryViewModel @Inject constructor(
    private val getAllSessionsUseCase: GetAllSessionsUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<State<SessionHistoryScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getHistory() {
        viewModelScope.launch {
            _screenState.emit(
                State.successes(
                    SessionHistoryScreenState(
                        getAllSessionsUseCase()
                    )
                )
            )
        }
    }

}