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
import nikasov.domain.usecase.chat.HandleNewAdviceUseCase
import nikasov.domain.usecase.chat.StartSessionUseCase
import nikasov.domain.usecase.favorites.AddToFavoritesUseCase
import javax.inject.Inject

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val startSessionUseCase: StartSessionUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val handleNewAdviceUseCase: HandleNewAdviceUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<State<AdviceScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    private var currentSessionId: Long? = null

    fun startSession(searchText: String) {
        viewModelScope.launch {
            _screenState.emit(State.loading())
            currentSessionId = startSessionUseCase(searchText)
            handleNewAdvices(searchText)
        }
    }

    fun searchForAdvices(searchText: String) {
        viewModelScope.launch {
            _screenState.emit(State.loading())
            handleNewAdvices(searchText)
        }
    }

    fun changeFavoriteState(advice: Advice) {
        viewModelScope.launch {
            addToFavoritesUseCase(advice)
        }
    }

    private suspend fun handleNewAdvices(searchText: String) {
        when(val advices = handleNewAdviceUseCase(searchText, currentSessionId ?: return)) {
            is DataState.Error -> _screenState.emit(State.error())
            is DataState.Success -> {
                _screenState.emit(
                    State.successes(
                        AdviceScreenState(
                            title = searchText,
                            adviceList = advices.data ?: emptyList()
                        )
                    )
                )
            }
        }
    }

}