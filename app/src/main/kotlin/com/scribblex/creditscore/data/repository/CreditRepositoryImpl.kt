package com.scribblex.creditscore.data.repository

import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.remote.CreditApiServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

class CreditRepositoryImpl @Inject constructor(
    private val apiImpl: CreditApiServiceImpl
) : CreditRepository {

    override suspend fun getCreditReport(): Flow<Result<CreditReport>> {
        return apiImpl.getCreditReport().map {
            if (it.isSuccess) {
                success(it.getOrNull()!!)
            } else {
                failure(it.exceptionOrNull()!!)
            }
        }
    }
}