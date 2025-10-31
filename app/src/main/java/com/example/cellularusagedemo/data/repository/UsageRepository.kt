package com.example.cellularusagedemo.data.repository

import com.example.cellularusagedemo.data.model.Plan
import com.example.cellularusagedemo.data.model.Usage
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UsageRepository @Inject constructor() {

    fun getUsage(): Usage = Usage(
        dataUsedGb = 2.3,
        dataLimitGb = 5.0,
        minutesUsed = 340,
        minutesLimit = 1000,
        smsUsed = 120,
        smsLimit = 500,
        balance = 55.50,
        renewalDate = "Nov 1, 2025"
    )

    fun getPromotions(): List<Plan> = listOf(
        Plan(
            "Super Saver 499",
            "₹499",
            "3GB/day",
            "1000m",
            "100 SMS"
        ),
        Plan(
            "Weekend Data Boost",
            "₹399",
            "5GB/day",
            "Unlimited",
            "500 SMS"
        )
    )

    fun getAvailablePlans(): List<Plan> = listOf(
        Plan(
            "Super 299",
            "₹299",
            "3GB/day",
            "1000m",
            "100 SMS"
        ),
        Plan(
            "Max 499",
            "₹499",
            "5GB/day",
            "Unlimited",
            "500 SMS"
        ),
        Plan(
            "Power 799",
            "₹799",
            "10GB/day",
            "Unlimited",
            "1000 SMS"
        )
    )
}