package com.example.cellularusagedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cellularusagedemo.ui.component.AppFooter
import com.example.cellularusagedemo.ui.component.AppTopBar
import com.example.cellularusagedemo.ui.dashboard.DashboardScreen
import com.example.cellularusagedemo.ui.theme.CellularUsageDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint


val LocalInnerPadding = staticCompositionLocalOf { PaddingValues(0.dp) }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            CellularUsageDemoAppTheme(darkTheme = isDarkTheme) {
                Scaffold(
                    topBar = {
                        AppTopBar(
                            isDarkTheme = isDarkTheme,
                            onThemeToggle = { isDarkTheme = it }
                        )
                    },
                    bottomBar = { AppFooter() },
                    content = { innerPadding ->
                        CompositionLocalProvider(
                            LocalInnerPadding provides innerPadding
                        ) {
                            DashboardScreen()
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CellularUsageDemoAppTheme {
        DashboardScreen()
    }
}