package com.example.cellularusagedemo.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cellularusagedemo.LocalNavHostController
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.common.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {

    val navigator = LocalNavHostController.current
    val currentBackStack by navigator.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    TopAppBar(
        title = {
            Text(
                when (currentRoute) {
                    Routes.HomeScreen -> stringResource(id = R.string.title)
                    Routes.SettingScreen -> stringResource(id = R.string.text_settings)
                    else -> "App"
                }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            if (currentRoute != Routes.HomeScreen) {
                IconButton(onClick = { navigator.popBackStack() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        actions = {
            if (currentRoute == Routes.HomeScreen) {
                IconButton(onClick = {
                    navigator.navigate(Routes.SettingScreen)
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    )
}