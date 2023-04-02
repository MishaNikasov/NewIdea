package com.nikasov.newidea

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.compose.rememberNavController
import com.nikasov.newidea.screen.root.RootScreen
import com.nikasov.theme.NewIdeaTheme
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
            val navHostController = rememberNavController()
            NewIdeaTheme(false) {
                RootScreen(navHostController)
            }
        }
    }
}