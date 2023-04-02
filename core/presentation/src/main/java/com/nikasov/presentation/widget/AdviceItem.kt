package com.nikasov.presentation.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.theme.NewIdeaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdviceItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onClick() },
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(4.dp, MaterialTheme.colorScheme.surface),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 5.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun AdviceItemPreview() {
    NewIdeaTheme {
        AdviceItem("Text", { })
    }
}