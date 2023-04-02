package com.nikasov.presentation.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*

@Composable
fun AdviceHistoryItem(
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 21.sp
            )
        }
    }
}