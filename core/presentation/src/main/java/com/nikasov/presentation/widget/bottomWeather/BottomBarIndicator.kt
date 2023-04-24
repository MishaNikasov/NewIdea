package com.nikasov.presentation.widget.bottomWeather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarIndicator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(24.dp)
            .height(3.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 2.dp,
                    topEnd = 2.dp
                )
            )
            .background(Color(0xFF3272CC))
    )
}