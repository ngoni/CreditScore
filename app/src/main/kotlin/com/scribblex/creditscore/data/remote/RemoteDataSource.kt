package com.scribblex.creditscore.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCreditReport() {
        apiService.getCreditReport()
    }
}