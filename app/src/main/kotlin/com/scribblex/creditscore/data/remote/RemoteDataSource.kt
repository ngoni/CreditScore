package com.scribblex.creditscore.data.remote

import com.scribblex.creditscore.data.entities.CreditReport
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCreditReport(): Flow<Result<CreditReport>> {
        return flow {
            emit(success(apiService.getCreditReport()))
        }.catch {
            emit(failure(RuntimeException("Something went wrong")))
        }
    }
}