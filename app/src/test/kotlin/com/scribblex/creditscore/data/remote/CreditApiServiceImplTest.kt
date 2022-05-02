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
class CreditApiServiceImplTest : BaseUnitTest() {

    private lateinit var apiImpl: CreditApiServiceImpl
    private val apiService = mock<CreditApiService>()
    private val creditReport = mock<CreditReport>()

    @Before
    fun setup() {
        apiImpl = CreditApiServiceImpl(apiService)
    }

    @Test
    fun `GIVEN getCreditReport is called, THEN verify that request is made to api`() {
        runTest {
            apiImpl.getCreditReport().first()
            verify(apiService, times(1)).getCreditReport()
        }
    }

    @Test
    fun `GIVEN getCreditReport is called, WHEN result is successful THEN response is converted to Flow`() =
        runTest {
            whenever(apiService.getCreditReport()).thenReturn(creditReport)
            assertThat(Result.success(creditReport)).isEqualTo(
                apiImpl.getCreditReport().first()
            )
        }

}