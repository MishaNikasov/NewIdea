package com.nikasov.presentation.widget.expandableForecast

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nikasov.presentation.widget.WaveShape

@Composable
fun ExpandableForecast() {
    WaveShape(
        tint = Color(0xFF141416),
        alpha = 1f,
        modifier = Modifier
            .rotate(180f)
    )
}

@Preview
@Composable
fun ExpandableForecastPreview() {
    ExpandableForecast()
}