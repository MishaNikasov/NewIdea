package com.nikasov.newidea.screen.advice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.DataState
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {

    private val _screenState = MutableStateFlow<State<AdviceScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    private var currentSessionId: Long? = null

    fun startSession(searchText: String) {
        viewModelScope.launch {
            currentSessionId = chatRepository.createSession(searchText)
            handleNewAdvices(searchText)
        }
    }

    fun searchForAdvices(searchText: String) {
        viewModelScope.launch {
            _screenState.emit(State.loading())
            handleNewAdvices(searchText)
        }
    }

    private suspend fun handleNewAdvices(searchText: String) {
        when(val result = chatRepository.getAdvices(searchText)) {
            is DataState.Error -> _screenState.emit(State.error())
            is DataState.Success -> {
                val list = result.data ?: emptyList()
                chatRepository.addAdvicesToSession(
                    sessionId = currentSessionId ?: return,
                    list = list
                )
                _screenState.emit(
                    State.successes(
                        AdviceScreenState(
                            title = searchText,
                            adviceList = list
                        )
                    )
                )
            }
        }
    }

}