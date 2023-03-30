package com.nikasov.newidea.screen.home

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.presentation.widget.AppButton
import com.nikasov.presentation.widget.EditField
import com.nikasov.theme.NewIdeaTheme

@Composable
fun HomeScreen(
    openAdvice: (String) -> Unit
) {

    val notificationPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {}
    )

    SideEffect {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
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
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) { searchText = it }
        Spacer(modifier = Modifier.weight(1f))
        AppButton(
            text = "Go for it!",
            modifier = Modifier.padding(12.dp)
        ) { openAdvice(searchText) }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    NewIdeaTheme {
        HomeScreen { }
    }
}