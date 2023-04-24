package com.nikasov.presentation.widget.bottomWeather

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikasov.presentation.R
import com.nikasov.presentation.widget.bottomWeather.utils.SelectionState

@Composable
fun BottomBarMiddleItem(
    selectionState: SelectionState,
    modifier: Modifier = Modifier
) {

    Crossfade(
        targetState = selectionState,
        modifier = modifier
    ) { state ->

        val borderColor = when (state) {
            SelectionState.Selected -> Color(0xFF3272CC)
            SelectionState.Unselected -> Color(0xFF727272)
        }

        val fillBg = state == SelectionState.Selected

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            val painter = when (state) {
                SelectionState.Selected -> painterResource(R.drawable.ic_earth_selected)
                SelectionState.Unselected -> painterResource(R.drawable.ic_earth_unselected)
            }
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = borderColor,
                        ),
                        shape = CircleShape
                    )
                    .size(60.dp)
                    .then(
                        if (fillBg) Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF0550B9),
                                        Color(0xFF2365C1),
                                        Color(0xFF3D77C9)
                                    ).reversed()
                                )
                            )
                        else Modifier
                    )
            )
            Image(
                painter = painter,
                contentDescription = "Main",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.Center)
            )
        }
    }

}

@Preview
@Composable
fun BottomBarMiddleItemPreview() {
    BottomBarMiddleItem(SelectionState.Selected)
}