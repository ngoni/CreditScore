package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreditRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : CreditRepository {

    override suspend fun loadCreditReport(): Flow<Result<CreditReport>> {
        return remoteDataSource.getCreditReport()
    }
}