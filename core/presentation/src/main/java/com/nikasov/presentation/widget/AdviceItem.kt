package com.nikasov.presentation.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.theme.NewIdeaTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdviceItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(4.dp, MaterialTheme.colors.surface),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp),
        elevation = 2.dp,
        onClick = { onClick() }
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