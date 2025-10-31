package com.example.cellularusagedemo.ui.component

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.cellularusagedemo.LocalInnerPadding
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.common.DashboardUiState
import com.example.cellularusagedemo.ui.dashboard.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardData(
    data: DashboardUiState.Success,
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val innerPadding = LocalInnerPadding.current

    LaunchedEffect(Unit) {
        viewModel.toastEvent.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    LazyColumn(
        contentPadding = innerPadding,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { UsageSummaryCard(data.usage) }

        item {
            Text(
                stringResource(id = R.string.promotions),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }


        items(data.promotions) { promo ->
            PromotionBanner(promo) { viewModel.knowMoreAboutThePlan(context, promo) }
        }


        item {
            Text(
                stringResource(id = R.string.available_plans),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }


        items(data.plans) { plan ->
            PlanRow(plan = plan) { viewModel.subscribeToPlan(context, plan) }
        }
    }
}