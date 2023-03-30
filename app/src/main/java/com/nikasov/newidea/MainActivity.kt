package com.nikasov.newidea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.nikasov.newidea.navigation.main.MainGraph
import com.nikasov.theme.NewIdeaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            NewIdeaTheme(false) {
                MainGraph(navHostController)
            }
        }
    }
}