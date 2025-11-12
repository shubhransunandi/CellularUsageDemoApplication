package com.example.cellularusagedemo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cellularusagedemo.common.Routes
import com.example.cellularusagedemo.ui.dashboard.DashboardScreen
import com.example.cellularusagedemo.ui.setting.SettingScreen

@Composable
fun CellularUsageAppNavigation() {
    val navigator = LocalNavHostController.current
    NavHost(navigator, startDestination = Routes.HomeScreen) {
        composable(Routes.HomeScreen) {
            DashboardScreen()
        }
        composable(Routes.SettingScreen) {
            SettingScreen()
        }
    }
}