package com.nikasov.presentation.widget.bottomWeather.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun ItemPosition.calculateState(currentPosition: ItemPosition) =
    if (currentPosition == this) SelectionState.Selected else SelectionState.Unselected

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}