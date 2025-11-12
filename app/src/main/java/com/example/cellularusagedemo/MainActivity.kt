package com.example.cellularusagedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cellularusagedemo.ui.component.AppFooter
import com.example.cellularusagedemo.ui.component.AppTopBar
import com.example.cellularusagedemo.ui.theme.CellularUsageDemoAppTheme
import com.example.cellularusagedemo.ui.theme.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint


val LocalInnerPadding = staticCompositionLocalOf { PaddingValues(0.dp) }
val LocalNavHostController = compositionLocalOf<NavHostController> { error("Error") }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(
                LocalNavHostController provides navController
            ) {
                val viewModel: ThemeViewModel = hiltViewModel()
                val isDarkTheme by viewModel.isDarkTheme.collectAsState()
                CellularUsageDemoAppTheme(darkTheme = isDarkTheme) {
                    Scaffold(
                        topBar = {
                            AppTopBar()
                        },
                        bottomBar = { AppFooter() },
                        content = { innerPadding ->
                            CompositionLocalProvider(
                                LocalInnerPadding provides innerPadding
                            ) {
                                CellularUsageAppNavigation()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CellularUsageDemoAppTheme {
        CellularUsageAppNavigation()
    }
}