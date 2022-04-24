package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.remote.CreditApiServiceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreditRepositoryImpl @Inject constructor(
    private val apiImpl: CreditApiServiceImpl
) : CreditRepository {

    override suspend fun getCreditReport(): Flow<Result<CreditReport>> {
        return apiImpl.getCreditReport()
    }
}