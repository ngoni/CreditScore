package com.scribblex.creditscore.data.remote

import com.google.common.truth.Truth.assertThat
import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.utils.BaseUnitTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@ExperimentalCoroutinesApi
class ApiServiceTest : BaseUnitTest() {

    private lateinit var remoteDataSource: RemoteDataSource
    private var api = mock<ApiService>()
    private val creditReport = mock<CreditReport>()

    @Before
    fun setup() {
        remoteDataSource = RemoteDataSource(api)
    }

    @Test
    fun `GIVEN getCreditReport is called, THEN verify that request is made to api`() {
        runTest {
            remoteDataSource.getCreditReport().first()
            verify(api, times(1)).getCreditReport()
        }
    }

    @Test
    fun `GIVEN getCreditReport is called, WHEN result is successful THEN response is converted to Flow`() =
        runTest {
            whenever(api.getCreditReport()).thenReturn(creditReport)
            assertThat(Result.success(creditReport)).isEqualTo(
                remoteDataSource.getCreditReport().first()
            )
        }

    @Test
    fun `GIVEN getCreditReport is called, WHEN result is failure THEN response is converted throw error`() =
        runTest {
            whenever(api.getCreditReport()).thenThrow(RuntimeException("Network Error"))
            assertThat("Something went wrong").isEqualTo(
                remoteDataSource.getCreditReport().first().exceptionOrNull()?.message
            )
        }

}