package com.nikasov.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nikasov.theme.NewIdeaTheme
import com.nikasov.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditField(
    label: String,
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        singleLine = true,
        label = { Text(text = label) },
        shape = Shapes.medium,
        onValueChange = {
            text = it
            onValueChanged(it)
        },
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun EditFieldPreview() {
    NewIdeaTheme {
        EditField("Text") { }
    }
}