package com.nikasov.newidea.screen.adviceHostory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.usecase.chat.GetSessionUseCase
import javax.inject.Inject

@HiltViewModel
class AdviceHistoryViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<State<AdviceHistoryScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getHistory(sessionId: Long) {
        viewModelScope.launch {
            _screenState.emit(
                State.successes(
                    AdviceHistoryScreenState(
                        session = getSessionUseCase(sessionId)
                    )
                )
            )
        }
    }

}