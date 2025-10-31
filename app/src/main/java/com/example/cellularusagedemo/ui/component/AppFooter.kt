package com.example.cellularusagedemo.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cellularusagedemo.R
import java.util.Calendar

@Composable
fun AppFooter() {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val appName = stringResource(R.string.app_name)
    val footerText = stringResource(R.string.footer_text, currentYear, appName)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = footerText,
            style = MaterialTheme.typography.bodySmall
        )
    }
}