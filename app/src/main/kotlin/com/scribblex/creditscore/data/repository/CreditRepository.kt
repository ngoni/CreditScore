package com.scribblex.creditscore.data.repository

import kotlinx.coroutines.flow.Flow

interface CreditRepository {
    // Make a GET call to some API
    suspend fun getCreditReport(): Flow<Result<Any>>
}