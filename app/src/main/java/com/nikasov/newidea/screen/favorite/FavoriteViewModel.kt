package com.nikasov.newidea.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.common.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nikasov.domain.usecase.favorites.GetAllFavoritesUseCase
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow<State<FavoriteScreenState>>(State.Idle)
    val screenState = _screenState.asStateFlow()

    fun getAllFavorites() {
        viewModelScope.launch {
            _screenState.emit(State.successes(FavoriteScreenState(adviceList = getAllFavoritesUseCase())))
        }
    }
}