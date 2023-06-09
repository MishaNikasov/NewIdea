package com.nikasov.newidea.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.newidea.navigation.advice.AdviceRouter
import com.nikasov.presentation.widget.AppButton
import com.nikasov.presentation.widget.EditField
import com.nikasov.theme.NewIdeaTheme

@Composable
fun HomeScreen(
    mainRouterEvent: (AdviceRouter) -> Unit
) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        var searchText = ""
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "What are you looking for?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(50.dp))
        EditField(
            label = "Your idea",
            modifier = Modifier.padding(horizontal = 24.dp),
            onValueChanged = { searchText = it }
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(
            text = "Go for it!",
            modifier = Modifier.padding(12.dp),
            onClick = { mainRouterEvent(AdviceRouter.Advice(searchText)) }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    NewIdeaTheme {
        HomeScreen { }
    }
}