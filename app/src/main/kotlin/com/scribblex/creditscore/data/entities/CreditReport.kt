package com.scribblex.creditscore.data.entities

import com.google.gson.annotations.SerializedName


data class CreditReport(

    @SerializedName("accountIDVStatus") var accountIDVStatus: String? = null,
    @SerializedName("creditReportInfo") var creditReportInfo: CreditReportInfo? = CreditReportInfo(),
    @SerializedName("dashboardStatus") var dashboardStatus: String? = null,
    @SerializedName("personaType") var personaType: String? = null,
    @SerializedName("coachingSummary") var coachingSummary: CoachingSummary? = CoachingSummary(),
    @SerializedName("augmentedCreditScore") var augmentedCreditScore: String? = null

)