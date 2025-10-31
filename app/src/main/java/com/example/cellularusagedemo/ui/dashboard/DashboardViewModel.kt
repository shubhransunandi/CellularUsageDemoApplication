package com.example.cellularusagedemo.ui.dashboard

import android.content.Context
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.common.DashboardUiState
import com.example.cellularusagedemo.data.model.Plan
import com.example.cellularusagedemo.data.repository.UsageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: UsageRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent = _toastEvent.asSharedFlow()


    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            delay(2000)
            try {
                val usage = repository.getUsage()
                val promos = repository.getPromotions()
                val plans = repository.getAvailablePlans()
                _uiState.value = DashboardUiState.Success(usage, promos, plans)
            } catch (e: Exception) {
                _uiState.value = DashboardUiState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }

    fun knowMoreAboutThePlan(context: Context, plan: Plan) {
        viewModelScope.launch {
            val message = context.getString(R.string.know_more_about, plan.name)
            _toastEvent.emit(message)
        }
    }

    fun subscribeToPlan(context: Context, plan: Plan) {
        viewModelScope.launch {
            val message = context.getString(R.string.subscribe_to, plan.name)
            _toastEvent.emit(message)
        }
    }
}