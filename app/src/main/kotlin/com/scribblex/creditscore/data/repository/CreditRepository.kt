package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.remote.RemoteDataSource
import javax.inject.Inject

class CreditRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getCreditReport() {
        remoteDataSource.getCreditReport()
    }
}