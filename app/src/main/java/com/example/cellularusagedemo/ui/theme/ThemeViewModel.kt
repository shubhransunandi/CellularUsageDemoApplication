package com.example.cellularusagedemo.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cellularusagedemo.data.datastore.ThemePreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themePreference: ThemePreference
) : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    init {
        viewModelScope.launch {
            themePreference.isDarkMode.collect { value ->
                _isDarkTheme.value = value
            }
        }
    }

    fun toggleTheme(enabled: Boolean) {
        viewModelScope.launch {
            themePreference.setDarkMode(enabled)
        }
    }
}