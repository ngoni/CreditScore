package com.scribblex.creditscore.data.entities

import com.google.gson.annotations.SerializedName


data class CreditReportInfo(

    @SerializedName("score") var score: Int? = null,
    @SerializedName("scoreBand") var scoreBand: Int? = null,
    @SerializedName("clientRef") var clientRef: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("maxScoreValue") var maxScoreValue: Int? = null,
    @SerializedName("minScoreValue") var minScoreValue: Int? = null,
    @SerializedName("monthsSinceLastDefaulted") var monthsSinceLastDefaulted: Int? = null,
    @SerializedName("hasEverDefaulted") var hasEverDefaulted: Boolean? = null,
    @SerializedName("monthsSinceLastDelinquent") var monthsSinceLastDelinquent: Int? = null,
    @SerializedName("hasEverBeenDelinquent") var hasEverBeenDelinquent: Boolean? = null,
    @SerializedName("percentageCreditUsed") var percentageCreditUsed: Int? = null,
    @SerializedName("percentageCreditUsedDirectionFlag") var percentageCreditUsedDirectionFlag: Int? = null,
    @SerializedName("changedScore") var changedScore: Int? = null,
    @SerializedName("currentShortTermDebt") var currentShortTermDebt: Int? = null,
    @SerializedName("currentShortTermNonPromotionalDebt") var currentShortTermNonPromotionalDebt: Int? = null,
    @SerializedName("currentShortTermCreditLimit") var currentShortTermCreditLimit: Int? = null,
    @SerializedName("currentShortTermCreditUtilisation") var currentShortTermCreditUtilisation: Int? = null,
    @SerializedName("changeInShortTermDebt") var changeInShortTermDebt: Int? = null,
    @SerializedName("currentLongTermDebt") var currentLongTermDebt: Int? = null,
    @SerializedName("currentLongTermNonPromotionalDebt") var currentLongTermNonPromotionalDebt: Int? = null,
    @SerializedName("currentLongTermCreditLimit") var currentLongTermCreditLimit: String? = null,
    @SerializedName("currentLongTermCreditUtilisation") var currentLongTermCreditUtilisation: String? = null,
    @SerializedName("changeInLongTermDebt") var changeInLongTermDebt: Int? = null,
    @SerializedName("numPositiveScoreFactors") var numPositiveScoreFactors: Int? = null,
    @SerializedName("numNegativeScoreFactors") var numNegativeScoreFactors: Int? = null,
    @SerializedName("equifaxScoreBand") var equifaxScoreBand: Int? = null,
    @SerializedName("equifaxScoreBandDescription") var equifaxScoreBandDescription: String? = null,
    @SerializedName("daysUntilNextReport") var daysUntilNextReport: Int? = null

)