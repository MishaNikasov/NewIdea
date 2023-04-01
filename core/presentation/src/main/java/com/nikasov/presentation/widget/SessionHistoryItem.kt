package com.nikasov.presentation.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.common.extensions.byPattern
import java.time.LocalDateTime

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionHistoryItem(
    title: String,
    date: LocalDateTime,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Black),
        onClick = { onClick() },
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
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date.byPattern("d MMM, HH:ss"),
                fontSize = 14.sp
            )
        }
    }
}