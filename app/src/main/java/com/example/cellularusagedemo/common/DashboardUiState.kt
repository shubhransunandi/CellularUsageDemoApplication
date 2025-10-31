package com.example.cellularusagedemo.common

import com.example.cellularusagedemo.data.model.Plan
import com.example.cellularusagedemo.data.model.Usage

sealed class DashboardUiState {
    object Loading : DashboardUiState()
    data class Success(
        val usage: Usage,
        val promotions: List<Plan>,
        val plans: List<Plan>
    ) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}
