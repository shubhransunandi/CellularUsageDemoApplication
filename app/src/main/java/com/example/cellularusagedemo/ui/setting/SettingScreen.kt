package com.example.cellularusagedemo.ui.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.cellularusagedemo.LocalInnerPadding
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.ui.theme.ThemeViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun SettingScreen(viewModel: ThemeViewModel = hiltViewModel()) {

    val innerPadding = LocalInnerPadding.current
    val isDarkTheme by viewModel.isDarkTheme.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    stringResource(id = R.string.text_dark_theme),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = { viewModel.toggleTheme(it) }
                )
            }
        }
}