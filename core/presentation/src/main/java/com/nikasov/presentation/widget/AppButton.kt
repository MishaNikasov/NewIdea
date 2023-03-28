package com.nikasov.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    action: () -> Unit
) {
    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        onClick = { action() },
        modifier = modifier.fillMaxWidth()
    ) {
        if (loading) {
            CircularProgressIndicator()
        } else {
            Text(
                fontWeight = FontWeight.Bold,
                text = text,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}