package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreditRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getCreditReport() : Flow<Result<CreditReport>> {
        return remoteDataSource.getCreditReport()
    }
}