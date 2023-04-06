package com.nikasov.newidea.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.repository.FavoriteRepository
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
): ViewModel() {

    private val _screenState = MutableStateFlow<State<FavoriteScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getAllFavorites() = viewModelScope.launch {
        val list = favoriteRepository.getAllFavorites()
        _screenState.emit(State.successes(FavoriteScreenState(adviceList = list)))
    }

}