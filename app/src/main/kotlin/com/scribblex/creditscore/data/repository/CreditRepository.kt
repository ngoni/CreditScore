package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.entities.CreditReport
import kotlinx.coroutines.flow.Flow

interface CreditRepository {
    // Make a GET call to some API
    suspend fun getCreditReport(): Flow<Result<CreditReport>>
}