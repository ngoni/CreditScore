package com.scribblex.creditscore.ui

import com.google.common.truth.Truth.assertThat
import com.scribblex.creditscore.data.entities.CreditReport
import com.scribblex.creditscore.data.repository.CreditRepositoryImpl
import com.scribblex.creditscore.utils.BaseUnitTest
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.Result.Companion.failure

@ExperimentalCoroutinesApi
class CreditReportViewModelTest : BaseUnitTest() {

    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private lateinit var viewModel: CreditReportViewModel
    private val repository = mock<CreditRepositoryImpl>()
    private val creditReport = mock<CreditReport>()
    private val exception = RuntimeException("Something went wrong")
    private var errorUiState = failure<java.lang.RuntimeException>(exception)

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
//        viewModel = CreditReportViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `GIVEN getCreditReport is called, THEN verify CreditReportViewModel requests data via repository`() =
        runTest {
            viewModel.getCreditReport()
            verify(repository, times(1)).getCreditReport()
        }

    @Test
    fun `GIVEN getCreditReport is called, THEN UiState Loading is emitted`() =
        runTest {
            viewModel.getCreditReport()
            val uiState = viewModel.viewState.value
            assertThat(uiState).isInstanceOf(UiState.Loading::class.java)
        }

    @Test
    fun `GIVEN getCreditReport returns successful response, THEN UiState Success is emitted`() =
        runTest {
//            viewModel = mockNetworkResponse(success = true)
            viewModel.getCreditReport()
            assertThat(UiState.Success(creditReport)).isEqualTo(viewModel.viewState.first())
        }

    @Test
    fun `GIVEN getCreditReport returns failure response, THEN UiState exception is emitted`() =
        runTest {
            viewModel = CreditReportViewModel(repository)
            mockNetworkResponse()

            val job = launch { viewModel.viewState.collect() }

            viewModel.getCreditReport()
            assertThat(errorUiState).isEqualTo(viewModel.viewState.first())

            job.cancel()


//            var assertionThrown = false
//            try {
//                val viewModel = CreditReportViewModel(repository)
//                viewModel.getCreditReport()
//            } catch(e: Exception) {
//                assertionThrown = true
//            }
//            assertThat(assertionThrown).isTrue()

        }

    private suspend fun mockNetworkResponse() {
        whenever(repository.getCreditReport()).thenReturn(
            flow {
                emit(failure(exception))
            }
        )
    }

//    private suspend fun mockNetworkResponse(success: Boolean = true): CreditReportViewModel {
//        whenever(repository.getCreditReport()).thenReturn(
//            flow {
//                if(success)
//                    emit(Result.success(creditReport))
//                else
//                    emit(Result.failure(RuntimeException("Something went wrong")))
//            }
//        )
//        return CreditReportViewModel(repository)
//    }
}