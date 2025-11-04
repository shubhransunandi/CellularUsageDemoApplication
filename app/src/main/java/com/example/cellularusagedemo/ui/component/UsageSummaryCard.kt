package com.example.cellularusagedemo.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cellularusagedemo.R
import com.example.cellularusagedemo.data.model.Usage
import java.text.DecimalFormat

@Composable
fun UsageSummaryCard(usage: Usage?) {

    val context = LocalContext.current
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                stringResource(id = R.string.usage_summary),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(4.dp))
            if (usage == null) {
                Text("Loading...")
            } else {
                val newDataUsage = DecimalFormat("#.##")
                UsageRow(
                    stringResource(id = R.string.data_used),
                    "${newDataUsage.format(usage.dataUsedGb)} GB of ${usage.dataLimitGb} GB",
                    (usage.dataUsedGb / usage.dataLimitGb).toFloat()
                )
                UsageRow(
                    stringResource(id = R.string.text_minutes),
                    "${usage.minutesUsed} / ${usage.minutesLimit}",
                    usage.minutesUsed.toFloat() / usage.minutesLimit
                )
                UsageRow(
                    stringResource(id = R.string.text_sms),
                    "${usage.smsUsed} / ${usage.smsLimit}",
                    usage.smsUsed.toFloat() / usage.smsLimit
                )

                Spacer(Modifier.height(4.dp))
                Text(
                    context.getString(R.string.balance, usage.balance.toString()),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    context.getString(R.string.renewal_date, usage.renewalDate),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}