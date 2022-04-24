package com.scribblex.creditscore.data.repository

interface CreditRepository {
    // Make a GET call to some API
    suspend fun loadCreditReport(): Any
}