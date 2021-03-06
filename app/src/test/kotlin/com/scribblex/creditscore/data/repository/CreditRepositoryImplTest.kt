package com.scribblex.creditscore.data.repository

import com.google.common.truth.Truth.assertThat
import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.remote.CreditApiServiceImpl
import com.scribblex.creditscore.utils.BaseUnitTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.lang.RuntimeException

@ExperimentalCoroutinesApi
class CreditRepositoryImplTest : BaseUnitTest() {

    private lateinit var repository: CreditRepositoryImpl
    private val apiServiceImpl = mock<CreditApiServiceImpl>()
    private val creditReport = mock<CreditReport>()
    private val throwable = mock<Throwable>()

    @Before
    fun setup() {
        repository = CreditRepositoryImpl(apiServiceImpl)
    }

    @Test
    fun `GIVEN getCreditReport is called, THEN verify repository request is made to api`() =
        runTest {
            repository.getCreditReport()
            verify(apiServiceImpl, times(1)).getCreditReport()
        }

    @Test
    fun `GIVEN getCreditReport returns successful response, THEN credit report is emitted`() =
        runTest {
            mockNetworkResponse(success = true)
            assertThat(Result.success(creditReport)).isEqualTo(repository.getCreditReport().first())
        }

    @Test
    fun `GIVEN getCreditReport returns failure response, THEN exception is emitted`() = runTest {
        mockNetworkResponse(success = false)
        val runtimeException = Result.failure<RuntimeException>(throwable)
        assertThat(runtimeException).isEqualTo(repository.getCreditReport().first())
    }

    private suspend fun mockNetworkResponse(success: Boolean = true) {
        whenever(repository.getCreditReport()).thenReturn(
            flow {
                emit(if (success) Result.success(creditReport) else Result.failure(throwable))
            }
        )
    }
}