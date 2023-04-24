package com.nikasov.newidea

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nikasov.presentation.widget.bottomWeather.BottomBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val permissionContract = registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionContract.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }

        setContent {
//            val navHostController = rememberNavController()
//            NewIdeaTheme(false) {
//                RootScreen(navHostController)
//            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF242632))
            ) {
                BottomBar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}