package com.example.cellularusagedemo.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.data.model.Plan

@Composable
fun PlanRow(plan: Plan, onSubscribe: () -> Unit) {
    CommonCard {
        CommonInfoColumn(
            title = plan.name,
            subtitle = "${plan.price} ${plan.data} ${plan.minutes} ${plan.sms}",
            modifier = Modifier.weight(1f)
        )
        CommonButton(
            text = stringResource(id = R.string.subscribe),
            onClick = onSubscribe
        )
    }
}