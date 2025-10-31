package com.example.cellularusagedemo.data.model

data class Usage(
    val dataUsedGb: Double,
    val dataLimitGb: Double,
    val minutesUsed: Int,
    val minutesLimit: Int,
    val smsUsed: Int,
    val smsLimit: Int,
    val balance: Double,
    val renewalDate: String
)
