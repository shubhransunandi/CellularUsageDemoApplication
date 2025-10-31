package com.example.cellularusagedemo.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.cellularusagedemo.common.DashboardUiState
import com.example.cellularusagedemo.ui.component.DashboardData

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState()

    when (state) {
        is DashboardUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is DashboardUiState.Error -> {
            val message = (state as DashboardUiState.Error).message
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: {'$'}$message")
            }
        }

        is DashboardUiState.Success -> {
            val data = state as DashboardUiState.Success
            DashboardData(data)
        }
    }
}


