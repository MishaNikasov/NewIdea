package com.nikasov.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikasov.colors.editFieldColors
import com.nikasov.theme.NewIdeaTheme
import com.nikasov.theme.Shapes

@Composable
fun EditField(
    label: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit,
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .shadow(8.dp)
    ) {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            singleLine = true,
            label = { Text(text = label) },
            shape = Shapes.medium,
            colors = editFieldColors(),
            onValueChange = {
                text = it
                onValueChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun EditFieldPreview() {
    NewIdeaTheme {
        EditField("Text") { }
    }
}